package com.lib;

import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.*;
import com.facebook.react.uimanager.*;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;

public class MPLineChart extends SimpleViewManager<LineChart> {
  public static final String REACT_CLASS = "MPLineChart";

  private final @Nullable Object mCallerContext;

  public MPLineChart(Object callerContext) {
    mCallerContext = callerContext;
  }

  public MPLineChart() {
    mCallerContext = null;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  ArrayList<String> labels = new ArrayList<String>();
  ArrayList<Entry> entries = new ArrayList<>();

  @ReactProp(name = "data")
  public void setData(LineChart chart, ReadableMap data) {
    entries.clear();
    labels.clear();
    ReadableArray d = data.getArray("data");
    ReadableArray l = data.getArray("labels");

    int size = d.size();
    for (int i = 0; i < size; i++) {
      entries.add(new Entry((float) d.getDouble(i), i));
    }

    size = l.size();
    for (int i = 0; i < size; i++) {
      labels.add(l.getString(i));
    }
    LineDataSet dataset = new LineDataSet(entries, "Code Camp");
    LineData lineData = new LineData(labels, dataset);

    dataset.setColors(ColorTemplate.COLORFUL_COLORS);
    dataset.setDrawCubic(true);
    dataset.setDrawFilled(true);


    chart.setData(lineData);
  }

  @Override
  public LineChart createViewInstance(ThemedReactContext context) {
    LineChart lineChart = new LineChart(context);
/*
    ArrayList<Entry> entries = new ArrayList<>();
    entries.add(new Entry(4f, 0));
    entries.add(new Entry(8f, 1));
    entries.add(new Entry(6f, 2));
    entries.add(new Entry(2f, 3));
    entries.add(new Entry(18f, 4));
    entries.add(new Entry(9f, 5));
    entries.add(new Entry(14f, 6));

    LineDataSet dataset = new LineDataSet(entries, "# of Calls");

    ArrayList<String> labels = new ArrayList<String>();
    labels.add("Sunday");
    labels.add("Monday");
    labels.add("Tuesday");
    labels.add("Wednesday");
    labels.add("Thursday");
    labels.add("Friday");
    labels.add("Saturday");

    LineData data = new LineData(labels, dataset);
    dataset.setColors(ColorTemplate.COLORFUL_COLORS);
    dataset.setDrawCubic(true);
    dataset.setDrawFilled(true);


    lineChart.setData(data);*/
    lineChart.animateY(2000);
    return lineChart;
  }

  public Object getCallerContext() {
    return mCallerContext;
  }
}