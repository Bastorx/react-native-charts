'use strict';

import { requireNativeComponent, PropTypes, Component, View } from 'react-native';

class LineChart extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <MPLineChart {...this.props}/>
        );
    }
}

LineChart.propTypes = {
	...View.propTypes,
    data: PropTypes.object.isRequired
};

var MPLineChart = requireNativeComponent('MPLineChart', LineChart);

module.exports = MPLineChart;