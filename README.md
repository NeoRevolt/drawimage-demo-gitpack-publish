# drawimage-demo-gitpack-publish
Demo android library for editing image for pest control.
Published using Jitpack.

## Requirements
* Android API lv16 or higher
* Android Gradle Plugin (AGP) 7.3.1

## Preparation
### 1. Generate GitHub Access Token
* Login to GitHub
* Go to Setting > Developer Settings > Personal Access Tokens > Generate new token
* Make sure you select the following scopes:

### 2. Create ``github.properties`` file within the root project
```properties
    gpr.usr=YOUR_USERNAME //Change with your username and acces key
    gpr.key=YOUR_KEY  //Change with your personal acces token before
```
Then add this properties to ``.gitignore``

## Usage / Implementation

### Gradle (settings.gradle)

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // Set to PREFER_SETTINGS
    repositories {
        google()
        mavenCentral()
        
        // Set target packages repo
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/NeoRevolt/drawimage-demo-gitpack-publish")
            credentials {
                username = 'gpr.usr'
                password = 'gpr.key'
            }
        }
    }
}
```

### Gradle (build.gradle/App)

```groovy
plugins {
    id 'kotlin-kapt'
}

android {
    compileSdk 33
    
    defaultConfig {
        targetSdk 33
    }
}

dependencies {
    implementation 'com.github.neorevolt:draw-image-gitpack:0.0.5'
}
```

# Sample Code
#### With previews:

MainActivity.kt
```kotlin
private lateinit var binding: ActivityMainBinding
public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    
    // Intent to Photo Editor with EXTRA Request (gallery/remote) and Image
    binding.apply {
            btnToLib.setOnClickListener {
            Intent(this@MainActivity, Class.forName("com.neorevolt.drawimage.EditImageActivity")).also {
                    it.putExtra(EditImageActivity.EXTRA_REQ,"remote")
                    it.putExtra(EditImageActivity.EXTRA_PHOTO,"https://w0.peakpx.com/wallpaper/205/460/HD-wallpaper-sea-beach-beautiful-scene-clouds-deep-sea-natural-graphy-nature-beauty-graphy-lover-portrait.jpg")
                    startActivity(it)
           }
     }      
}
```
