/*
 * Copyright (C) 2014 Moncef YABI
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.koge.game.sprite

import org.joml.Vector2f
import org.koge.engine.exception.TextureNotSetException
import org.koge.engine.graphics.Model
import org.koge.engine.graphics.ModelBuilder
import org.koge.engine.graphics.texture.Texture
import org.koge.engine.graphics.texture.TextureLoader
import org.koge.game.animation.Animation
import org.koge.game.animation.Frame



/**
 * This is the animated Sprite class
 *
 * @author Moncef YABI
 */
class FSprite(private val rows:Int, private val columns:Int) : Sprite() {
    private var models= arrayOf<Model>()
    private val animationsFrames: ArrayList<Animation> = ArrayList()
    private val frames: ArrayList<Frame>  =  ArrayList()

    var delay = 0

    lateinit var activeAnimation: Animation
    lateinit var texture: Texture
    var activeAnimationName: String? = null

    override fun init() {

        if (texturePath == "") throw TextureNotSetException("Texture path was not set!!")
        position= Vector2f(xPos, yPos)
        extractModelsFromSpriteSheet()

        var tempImageArray= arrayOf<Model>()
        var index = 0
        for (frame in frames) {

            if (frame.count > 1) {
                tempImageArray = models.copyOfRange(index, index + frame.count)
                index += frame.count
            } else if (frame.count == 1) {
                tempImageArray = arrayOf()
                tempImageArray += models[index + frame.count - 1]
                index += frame.count
            }

            animationsFrames.add(Animation(frame.name, tempImageArray, delay, frame.loop))
        }
        setActiveAnimation(activeAnimationName)
    }

    fun startAnimation()
    {
        activeAnimation.start=true
        activeAnimation.stoped=false
    }

    fun stopAnimation()
    {
        activeAnimation.start=false
        activeAnimation.stoped=true
    }

    private fun extractModelsFromSpriteSheet() {
        texture = TextureLoader.create(texturePath)
        val iSubs = TextureLoader.getImageFramesFromSpriteSheetTexture(texture, columns, rows)
        var modelsSheet = arrayOf<Array<Model>>()
        iSubs.forEach { iSubsRow ->
            var modelRow = arrayOf<Model>()
            iSubsRow.forEach { element ->
                modelRow += ModelBuilder.createModelFromSubImage(texture, element)
            }
            modelsSheet += modelRow
        }
        modelsSheet.reverse()
        modelsSheet.forEach { row ->
            row.forEach { model ->
                models+=model
            }
        }
    }

    fun setActiveAnimation(index: Int) {
        activeAnimation = animationsFrames[index]
    }

    fun setActiveAnimation(name: String?) {
        for (animation in animationsFrames) {
            if (animation.name == name) {
                activeAnimation = animation
            }
        }
    }

    override fun getModel(): Model {

        activeAnimation.update()
        return activeAnimation.models[activeAnimation.counter]
    }

    override fun destroy() {
        animationsFrames.forEach { animation ->
            animation.models.forEach {model ->
                model.destroy()
            }
        }

        texture.destroy()
    }

    /**
     * DSL Wrapper for the frame function
     *
     * @param block: lambda function
     */
    fun frame(block: Frame.()->Unit)  {
        frames.add(Frame().apply(block))
    }
}

/**
 * DSL Wrapper for the fsprite function
 *
 * @param block: lambda function
 */
fun fsprite(rows:Int, columns:Int,block: FSprite.()->Unit): FSprite = FSprite(rows,columns).apply(block)