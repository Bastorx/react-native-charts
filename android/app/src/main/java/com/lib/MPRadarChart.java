package com.lib;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.facebook.react.uimanager.*;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

public class MPRadarChart extends SimpleViewManager<RadarChart> {
  public static final String REACT_CLASS = "MPRadarChart";

  private final @Nullable Object mCallerContext;

  public MPRadarChart(Object callerContext) {
    mCallerContext = callerContext;
  }

  public MPRadarChart() {
    mCallerContext = null;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public RadarChart createViewInstance(ThemedReactContext context) {
    RadarChart chart = new RadarChart(context);

    ArrayList<Entry> entries = new ArrayList<>();
    entries.add(new Entry(9f, 0));
    entries.add(new Entry(5f, 1));
    entries.add(new Entry(2f, 2));
    entries.add(new Entry(9f, 3));
    entries.add(new Entry(8f, 4));
    entries.add(new Entry(5f, 5));

    ArrayList<Entry> entries2 = new ArrayList<>();
    entries2.add(new Entry(1f, 0));
    entries2.add(new Entry(5f, 1));
    entries2.add(new Entry(6f, 2));
    entries2.add(new Entry(6f, 3));
    entries2.add(new Entry(11f, 4));
    entries2.add(new Entry(8f, 5));

    ArrayList<Entry> entries3 = new ArrayList<>();
    entries3.add(new Entry(10f, 0));
    entries3.add(new Entry(9f, 1));
    entries3.add(new Entry(7f, 2));
    entries3.add(new Entry(6f, 3));
    entries3.add(new Entry(11f, 4));
    entries3.add(new Entry(2f, 5));

    RadarDataSet dataset_comp1 = new RadarDataSet(entries, "Company1");

    RadarDataSet dataset_comp2 = new RadarDataSet(entries2, "Company2");

    RadarDataSet dataset_comp3 = new RadarDataSet(entries3, "Company3");

    dataset_comp1.setColor(Color.BLUE);
    dataset_comp1.setDrawFilled(true);

    dataset_comp2.setColor(Color.RED);
    dataset_comp2.setDrawFilled(true);

    dataset_comp3.setColor(Color.YELLOW);
    dataset_comp3.setDrawFilled(true);


    ArrayList<RadarDataSet> dataSets = new ArrayList<RadarDataSet>();
    dataSets.add(dataset_comp1);
    dataSets.add(dataset_comp2);
    dataSets.add(dataset_comp3);

    ArrayList<String> labels = new ArrayList<String>();
    labels.add("Communication");
    labels.add("Technical Knowledge");
    labels.add("Team Player");
    labels.add("Meeting Deadlines");
    labels.add("Problem Solving");
    labels.add("Punctuality");


    RadarData data = new RadarData(labels, (IRadarDataSet) dataSets);
    chart.setData(data);
    String description = "Employee-Skill Analysis (scale of 1-10), 10 being the highest";
    chart.setDescription(description);
    chart.setWebLineWidthInner(0.5f);
    chart.setDescriptionColor(Color.RED);

    //chart.setSkipWebLineCount(10);
    chart.invalidate();
    chart.animate();
    return chart;
  }

  public Object getCallerContext() {
    return mCallerContext;
  }
}