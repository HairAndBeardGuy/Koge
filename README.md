# Koge 
![logo](https://github.com/KogeLabs/Koge/blob/master/koge_logo.png?raw=true)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/773e224e434d411cb632f0829516cec4)](https://www.codacy.com/gh/KogeLabs/Koge?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=KogeLabs/Koge&amp;utm_campaign=Badge_Grade) 
![Java CI with Gradle](https://github.com/KogeLabs/Koge/workflows/Java%20CI%20with%20Gradle/badge.svg)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.kogelabs/koge-jvm.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.kogelabs%22%20AND%20a:%22koge-jvm%22)


Koge (Kotlin OpenGL Game Engine) is a 2D game framework developed in Kotlin that works in Windows, Linux and Mac OS X.

## Pre-Requirements
*   Java JDK
*   IntelliJ IDEA (community or Ultimate edition)
*   Gradle
 
## Getting Started 

![Mario](https://github.com/KogeLabs/Koge/blob/master/Mario-Koge.png?raw=true)

In the ```build.gradle``` of your Idea project you want to add the following script to download Koge and their dependencies from the maven central.
```Groovy
repositories {
    mavenCentral()
}

dependencies {

    implementation 'com.github.kogelabs:koge-jvm:<version>'
}
```
For more information on how to set up Koge, please visit the [Getting Started](https://github.com/MoncefYabi/Koge/wiki/Getting-Started) page.

## Documentation
The [Wiki](https://github.com/MoncefYabi/Koge/wiki) contains all the information you'll need to write a Koge game. You can contribute to the Wiki directly here on GitHub!
## License 
Koge is licensed under the [GNU GPL 2.0 License](http://www.gnu.org/licenses/old-licenses/gpl-2.0.html). This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

Copyright (C) 2020 Moncef YABI
