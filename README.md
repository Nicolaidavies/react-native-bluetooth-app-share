
# React Native Bluetooth Share

Allows you to share your react native app's .apk file via bluetooth.

It looks for the current app's apk file, renames it to the name provided and then sends it via bluetooth to another phone.

It's useful in places where access to internet is limited. Originally created for the Emoyeni app which works completely offline.

## Getting started

`$ npm install react-native-bluetooth-share --save`

### Mostly automatic installation

`$ react-native link react-native-bluetooth-share`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBluetoothSharePackage;` to the imports at the top of the file
  - Add `new RNBluetoothSharePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-bluetooth-share'
  	project(':react-native-bluetooth-share').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-bluetooth-share/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-bluetooth-share')
  	```

## Usage
```javascript
import RNBluetoothShare from 'react-native-bluetooth-share';


RNBluetoothShare.sendAPK('app_name');
```
  