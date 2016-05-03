import React, {
  AppRegistry,
  ScrollView,
  Component
} from 'react-native';

import Charts, {
  Line,
  Histogram,
  Bar,
  Pie
} from './lib';

class Main extends Component {
  render() {
    return (
      <ScrollView>
        <Line />
      </ScrollView>
    );
  }
}

AppRegistry.registerComponent('react_native_charts', () => Main);
