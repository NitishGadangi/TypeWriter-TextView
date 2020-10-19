# TypeWriter
Android Library to Get Smooth and Polished Typewriter Effect for TextView

![demo](https://github.com/NitishGadangi/TypeWriter-TextView/blob/master/demo.gif?raw=true)


## Gradle Dependency

To get a Git project into your build:

**Step 1.**  Add the JitPack repository to your build file

Add it in your project level build.gradle at the end of repositories:

```css
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.**  Add the dependency to app level build.gradle file

```css
	dependencies {
	        implementation 'com.github.NitishGadangi:TypeWriter-TextView:v1.3'
	}
```

## Usage
**Step 1.** Add TypeWriterView to your XML file
``` XML
<com.nitish.typewriterview.TypeWriterView  
  android:id="@+id/typeWriterView"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
 />
```
**Step 2.** Start animation in Activity or Fragment
```JAVA
TypeWriterView typeWriterView = findViewById(R.id.typeWriterView);
typeWriterView.animateText("Insert your text here");

```

## Listeners and Functions
Callback for OnAnimation End
```JAVA
typeWriterView.setOnAnimationChangeListener(new TypeWriterView.OnAnimationChangeListener() {  
    @Override  
  public void onAnimationEnd() {  
          //Do something
    }  
});
```
Other Functions
```JAVA
typeWriterView.isAnimationRunning(); //returns true if animation is still running
typeWriterView.stopAnimation(); //Stop the ongoing animation
typeWriterView.isTextInitialised(); //returns false if animation is not started
```

## Customization
By default
```JAVA
avoidTextOverflowAtEdge = true;
characterDelay = 40; //in ms
```
You can modify the following values
```JAVA
//set characterDelay in ms
typeWriterView.setCharacterDelay(long millis);
//making this false will turnoff adding new line when the view hits the end of the view
typeWriterView.avoidTextOverflowAtEdge(boolean avoidTextOverflowAtEdge);
```
## Contributing
Pull requests are welcome, if you have any questions feel free to ping me.
### Like my work?
[![Buy me a coffee](https://camo.githubusercontent.com/d85bdd7af09d35c56f2e2ecba7a7342d3cd3c137/68747470733a2f2f626d632d63646e2e6e7963332e6469676974616c6f6365616e7370616365732e636f6d2f424d432d627574746f6e2d696d616765732f637573746f6d5f696d616765732f6f72616e67655f696d672e706e67)](https://nitishgadangi.github.io/?buy_me_coffee)

**Made with  ❤️  by Nitish**
