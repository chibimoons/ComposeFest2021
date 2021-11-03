package com.example.jetpackcomposecodelabweek2_1

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposecodelabweek2_1.ui.theme.JetpackComposeCodelabWeek2_1Theme


@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button1, button2, text) = createRefs()
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button1")
        }

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })

        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) {
            Text("Button2")
        }
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        ConstraintLayoutContent()
    }
}

@Composable
fun LargeConstraintLayout() {
    ConstraintLayout {
        val text = createRef()
        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            "thisis a very very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(start = guideline, end = parent.end)
                width = Dimension.preferredWrapContent
            }
        )
    }
}

@Preview
@Composable
fun LargeConstraintLayoutPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        LargeConstraintLayout()
    }
}

@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(16.dp)
        } else {
            decoupledConstraints(21.dp)
        }
        ConstraintLayout(constraints) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.layoutId("button")) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }

}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet() {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Preview(widthDp = 120, heightDp = 120)
@Composable
fun DecoupledConstraintLayoutSquarePreview() {
    JetpackComposeCodelabWeek2_1Theme {
        DecoupledConstraintLayout()
    }
}

@Preview(widthDp = 120, heightDp = 240)
@Composable
fun DecoupledConstraintLayoutRectPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        DecoupledConstraintLayout()
    }
}