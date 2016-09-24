import {NativeModules} from 'react-native';
import resolveAssetSource from 'resolveAssetSource';

const {RNBottomDialog} = NativeModules;
export default {
    show({
        title = '',
        items = [],
        canceledOnTouchOutside = true,
        cancelable = true
    } = {}, callback) {
        items = items.map((item) => {
            if (typeof item == 'string') {
                return {title: item};
            }
            else if (typeof item == 'object') {
                if (item.hasOwnProperty('icon')) {
                    item.icon = resolveAssetSource(item.icon);
                }
            }
            return item;
        });
        RNBottomDialog.show(title, items, canceledOnTouchOutside, cancelable, callback);
    }
};
