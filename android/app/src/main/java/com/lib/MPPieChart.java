package com.lib;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.*;
import com.facebook.react.uimanager.*;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class MPPieChart extends SimpleViewManager<PieChart> {
  public static final String REACT_CLASS = "MPPieChart";

  private final @Nullable Object mCallerContext;

  public MPPieChart(Object callerContext) {
    mCallerContext = callerContext;
  }

  public MPPieChart() {
    mCallerContext = null;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  private PieChart mChart;
  private ArrayList<Float> yData = new ArrayList<Float>();
  private ArrayList<String> xData = new ArrayList<String>();

  @ReactProp(name = "data")
  public void setData(PieChart chart, ReadableMap data) {
    ReadableArray p = data.getArray("percents");
    ReadableArray l = data.getArray("labels");

    yData.clear();
    xData.clear();

    int size = p.size();
    for (int i = 0; i < size; i++) {
      yData.add((float) p.getDouble(i));
    }

    size = l.size();
    for (int i = 0; i < size; i++) {
      xData.add(l.getString(i));
    }

    addData(chart);
  }

  @Override
  public PieChart createViewInstance(final ThemedReactContext context) {
    mChart = new PieChart(context);
    mChart.setUsePercentValues(true);
    mChart.setDescription("code camp");
    mChart.setDrawHoleEnabled(true);
    mChart.setHoleRadius(7);
    mChart.setTransparentCircleRadius(10);
    mChart.setRotationAngle(0);
    mChart.setRotationEnabled(true);
    mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
      @Override
      public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if (e == null)
          return;

        Toast.makeText(context,
                xData.get(e.getXIndex()) + " = " + e.getVal() + "%", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected() {

      }
    });

    Legend l = mChart.getLegend();
    l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
    l.setXEntrySpace(7);
    l.setYEntrySpace(5);

    return mChart;
  }


  private void addData(PieChart mChart) {
    ArrayList<Entry> yVals1 = new ArrayList<Entry>();

    for (int i = 0; i < yData.size(); i++)
      yVals1.add(new Entry(yData.get(i), i));

    ArrayList<String> xVals = new ArrayList<String>();

    for (int i = 0; i < xData.size(); i++)
      xVals.add(xData.get(i));

    // create pie data set
    PieDataSet dataSet = new PieDataSet(yVals1, "lol");
    dataSet.setSliceSpace(3);
    dataSet.setSelectionShift(5);

    // add many colors
    ArrayList<Integer> colors = new ArrayList<Integer>();

    for (int c : ColorTemplate.VORDIPLOM_COLORS)
      colors.add(c);

    for (int c : ColorTemplate.JOYFUL_COLORS)
      colors.add(c);

    for (int c : ColorTemplate.COLORFUL_COLORS)
      colors.add(c);

    for (int c : ColorTemplate.LIBERTY_COLORS)
      colors.add(c);

    for (int c : ColorTemplate.PASTEL_COLORS)
      colors.add(c);

    colors.add(ColorTemplate.getHoloBlue());
    dataSet.setColors(colors);

    // instantiate pie data object now
    PieData data = new PieData(xVals, dataSet);
    data.setValueFormatter(new PercentFormatter());
    data.setValueTextSize(11f);
    data.setValueTextColor(Color.GRAY);

    mChart.setData(data);

    // undo all highlights
    mChart.highlightValues(null);

    // update pie chart
    mChart.invalidate();
  }

  public Object getCallerContext() {
    return mCallerContext;
  }
}