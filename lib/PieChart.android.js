'use strict';

import { requireNativeComponent, PropTypes, Component, View } from 'react-native';

class PieChart extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <MPPieChart {...this.props}/>
        );
    }
}

PieChart.propTypes = {
	...View.propTypes,
    data: PropTypes.object.isRequired
};

var MPPieChart = requireNativeComponent('MPPieChart', PieChart);

module.exports = MPPieChart;