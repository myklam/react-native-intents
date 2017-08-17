# react-native-intents

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
```javascript
import RNIntents from 'react-native-intents';

// TODO: What to do with the module?
RNIntents;
```