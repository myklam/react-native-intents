# react-native-intents

react-native-intents allows you to launch intents from within you React Native app. The module only works for Android. There is not a lot to it, and I don't have a ton of time to work on it. If there are issues, let me know, and I'd love some help developing it.

The inspiration for this project is the [Expo](https://expo.io/) framework, which offers a very similar functionality using the [IntentLauncherAndroid](https://docs.expo.io/versions/latest/sdk/intent-launcher.html). I just wanted a way to perform this action without installing Expo.

## Getting started

`$ npm install react-native-intents --save`

### Mostly automatic installation

`$ react-native link react-native-intents`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNIntentsPackage;` to the imports at the top of the file
  - Add `new RNIntentsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-intents'
  	project(':react-native-intents').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-intents/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-intents')
  	```


## Usage

You need to look up the hardcoded strings for Intent actions,and categories. Those can be found on the [Android Developer Intents](https://developer.android.com/reference/android/content/Intent.html) page

This example would allow you to redirect users to the homescreen:

```javascript
import RNIntents from 'react-native-intents';

function goHome() {
	const ACTION_MAIN = "android.intent.action.MAIN";
	const CATEGORY_HOME = "android.intent.category.HOME";

	RNIntents.launchIntent(ACTION_MAIN, CATEGORY_HOME);
}
```

The other method currently provided allows you to kill you application after launching the intent.


```javascript
function goHomeAndKillApplication() {
	const ACTION_MAIN = "android.intent.action.MAIN";
	const CATEGORY_HOME = "android.intent.category.HOME";

    RNIntents.launchIntentAndKillActivity(ACTION_MAIN, CATEGORY_HOME);
}

## TODO:
- [ ] Export strings for commonly used Intents, Categories, and Flags
- [ ] Edit Java method to handle calling launchIntents with different args. Currently, you must supply ```null``` if you don't want to include a category
