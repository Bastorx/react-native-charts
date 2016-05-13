'use strict';

import { requireNativeComponent, PropTypes, Component, View } from 'react-native';

class RadarChart extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <MPRadarChart {...this.props}/>
        );
    }
}

RadarChart.propTypes = {
	...View.propTypes
};

var MPRadarChart = requireNativeComponent('MPRadarChart', RadarChart);

module.exports = MPRadarChart;