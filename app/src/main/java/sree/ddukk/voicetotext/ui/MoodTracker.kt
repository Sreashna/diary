package sree.ddukk.voicetotext.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoodTracker(
    selectedMood: String?,
    onMoodSelected: (String) -> Unit
) {
    val moodOptions = listOf("😊", "😐", "😢", "😠", "😫")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "How do you feel?",
            fontWeight = FontWeight.ExtraLight,
            color = Color(0xFF4B2E2E),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            moodOptions.forEach { mood ->
                val isSelected = mood == selectedMood
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color(0xFFF5C7C7) else Color(0xFFFBEFEF))
                        .clickable { onMoodSelected(mood) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = mood, fontSize = 24.sp)
                }
            }
        }
    }
}
@Preview
@Composable
fun MoodTrackerPreview() {
    MoodTracker(selectedMood = null, onMoodSelected = {})
}
