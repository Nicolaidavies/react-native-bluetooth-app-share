
# react-native-bluetooth-share

## Getting started

`$ npm install react-native-bluetooth-share --save`

### Mostly automatic installation

`$ react-native link react-native-bluetooth-share`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-bluetooth-share` and add `RNBluetoothShare.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBluetoothShare.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNBluetoothShare.sln` in `node_modules/react-native-bluetooth-share/windows/RNBluetoothShare.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNBluetoothShare;` to the usings at the top of the file
  - Add `new RNBluetoothSharePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNBluetoothShare from 'react-native-bluetooth-share';

// TODO: What to do with the module?
RNBluetoothShare;
```
  