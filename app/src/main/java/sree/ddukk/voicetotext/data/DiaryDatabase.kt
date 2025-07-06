package sree.ddukk.voicetotext.data

import androidx.lifecycle.ViewModel

class DiaryViewModel : ViewModel() {

    private val _entries = mutableListOf<DiaryEntry>()

    val entries: List<DiaryEntry>
        get() = _entries

    fun saveEntry(entry: DiaryEntry) {
        _entries.add(0, entry)
    }
}

