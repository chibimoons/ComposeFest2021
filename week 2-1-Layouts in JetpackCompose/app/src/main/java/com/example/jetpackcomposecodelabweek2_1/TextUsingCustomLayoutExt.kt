package com.example.jetpackcomposecodelabweek2_1

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecodelabweek2_1.ui.theme.JetpackComposeCodelabWeek2_1Theme

@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
    JetpackComposeCodelabWeek2_1Theme {
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        Text("Hi there!", Modifier.padding(top = 32.dp))
    }
}