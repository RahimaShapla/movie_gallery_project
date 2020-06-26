package com.pro.movie.data.local

import androidx.recyclerview.selection.SelectionTracker
import com.pro.movie.ui.base.callback.SelectionListener

/**
 * This is model class for passing parameters to build selection tracker of a selectable RecyclerView.
 * @property selectionId selection id of the tracker
 * @property willSelectSingleItem if single item is to be selected
 * @property trackerObjectFromActivityOrFragment selection tracker object from activity of fragment
 * @property selectionListener listener to get the states of selection
 */
data class SelectionTrackerParameters(
        val selectionId: String,
        val willSelectSingleItem: Boolean,
        var trackerObjectFromActivityOrFragment: SelectionTracker<Long>?,
        val selectionListener: SelectionListener?)