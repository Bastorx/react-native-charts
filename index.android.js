import React, {
  AppRegistry,
  ScrollView,
  Component,
  Text
} from 'react-native';

import LineChart from './lib/LineChart';
import PieChart from './lib/PieChart';
import BarChart from './lib/BarChart';
import RadarChart from './lib/RadarChart';

class Main extends Component {
  render() {
    return (
      <ScrollView>
        <LineChart style={{height: 350, width: 350}}
         data={{data: [10, 4, 12.5, 8], labels: ["Bastien", "Adrien", "Boris", "Morgane"]}} />
        <PieChart style={{height: 350, width: 350}}
        data={{percents: [10, 4, 12.5, 8], labels: ["Bastien", "Adrien", "Boris", "Morgane"]}}/>
        <BarChart style={{height: 350, width: 350}} 
        data={{data: [10, 4, 12.5, 8], labels: ["Bastien", "Adrien", "Boris", "Morgane"]}}/>
      </ScrollView>
    );
  }
}

AppRegistry.registerComponent('react_native_charts', () => Main);
