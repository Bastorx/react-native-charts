package com.lib;

import android.graphics.Color;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.*;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class MPBarChart extends SimpleViewManager<BarChart> {
  public static final String REACT_CLASS = "MPBarChart";

  private final @Nullable Object mCallerContext;

  public MPBarChart(Object callerContext) {
    mCallerContext = callerContext;
  }

  public MPBarChart() {
    mCallerContext = null;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  private ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
  private ArrayList<String> xAxis = new ArrayList<String>();

  @ReactProp(name = "data")
  public void setData(BarChart chart, ReadableMap data) {
    valueSet1.clear();
    xAxis.clear();
    ReadableArray d = data.getArray("data");
    ReadableArray l = data.getArray("labels");

    int size = d.size();
    for (int i = 0; i < size; i++) {
      valueSet1.add(new BarEntry((float) d.getDouble(i), i));
    }

    size = l.size();
    for (int i = 0; i < size; i++) {
      xAxis.add(l.getString(i));
    }

    BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
    barDataSet1.setColor(Color.rgb(0, 155, 0));


    BarData barData = new BarData(xAxis, barDataSet1);
    chart.setData(barData);
    chart.setDescription("My Chart");
    chart.animateXY(2000, 2000);
    chart.invalidate();
  }

  @Override
   public BarChart createViewInstance(ThemedReactContext context) {
    BarChart chart = new BarChart(context);

    return chart;
  }

  public Object getCallerContext() {
    return mCallerContext;
  }
}