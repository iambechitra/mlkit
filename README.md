# Android Machine Learning Library Powered by Java

### Gradle Setup:

##### Step 1. Add the JitPack repository to your build file
###### Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
##### Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.iambechitra:mlkit:v1.0-beta.2'
	}
```

### Maven Setup:
##### Step 1. Add the JitPack repository to your build file
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
##### Step 2. Add the dependency
```
	<dependency>
	    <groupId>com.github.iambechitra</groupId>
	    <artifactId>mlkit</artifactId>
	    <version>v1.0-beta.2</version>
	</dependency>
```

Enjoy (y)
