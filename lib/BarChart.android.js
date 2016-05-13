'use strict';

import { requireNativeComponent, PropTypes, Component, View } from 'react-native';

class BarChart extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <MPBarChart {...this.props}/>
        );
    }
}

BarChart.propTypes = {
	...View.propTypes,
    data: PropTypes.object.isRequired
};

var MPBarChart = requireNativeComponent('MPBarChart', BarChart);

module.exports = MPBarChart;