import {NativeModules} from 'react-native';

const {RNBottomDialog} = NativeModules;

export default {
    show({
        title = '',
        items = [],
        canceledOnTouchOutside = true,
        cancelable = true
    } = {}, callback) {
        RNBottomDialog.show(title, items, canceledOnTouchOutside, cancelable, callback);
    }
};
