
# react-native-bottomdialog
React-Native native module for show bottom dialog on Android

<img src="https://raw.githubusercontent.com/ga2mer/react-native-bottomdialog/master/screenshots/1.png" width="250">
<img src="https://raw.githubusercontent.com/ga2mer/react-native-bottomdialog/master/screenshots/2.png" width="250">
## Getting started

`$ npm install react-native-bottomdialog --save`

### Mostly automatic installation

`$ react-native link react-native-bottomdialog`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.ga2mer.bottomdialog.RNBottomDialogPackage;` to the imports at the top of the file
  - Add `new RNBottomDialogPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-bottomdialog'
  	project(':react-native-bottomdialog').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-bottomdialog/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-bottomdialog')
  	```


## Usage
```javascript
import BottomDialog from 'react-native-bottomdialog';
...
var quality = ["720p", "480p", "360p", "240p"];
var items = ["Quality"];
//or
items = [{title: "Quality"}, {title: "Closed Captions", icon: require('./img/cc.png')}];
//or
items = ["Quality", {title: "Closed Captions", icon: require('./img/cc.png')}];
BottomDialog.show({
    items
}, () => {
    BottomDialog.show({
        title: 'Select quality', //It will not show title if title is empty
        items: quality, //It will not show dialog if items is empty
        canceledOnTouchOutside: true, // close dialog if touch outside, default: true
        cancelable: true // close dialog if press "Back" or touch outside, default: true
    }, (selected) => { // onPress callback, return position of selected item
        console.log(quality[selected]);
    });
});
```
## TODO
- [x]  Icons

## Thanks
- [rebus007](https://github.com/rebus007) for great [bottom dialogs](https://github.com/rebus007/BottomDialog/)
