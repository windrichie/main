package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.timetable.Activity;
import seedu.address.model.person.timetable.TimeTable;

import java.util.ArrayList;
import java.util.logging.Logger;

//@@author windrichie

/**
 * Panel containing the list of activities (Timetable).
 */
public class ActivityListPanel extends UiPart<Region> {
    private static final String FXML = "ActivityListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ActivityListPanel.class);

    @FXML
    private ListView<Activity> activityListView;

    public ActivityListPanel(TimeTable timetable) {
        super(FXML);

        String[][] activityArray = timetable.getTimeTableArray();
        ArrayList<Activity> activityList = new ArrayList<>();
        for (int row = 0; row < activityArray.length; row++) {
            for (int col = 0; col < activityArray[row].length; col++) {
                // System.out.println("Checking for non null activities r,c = " + row + col +
                        // ", value = " + activityArray[row][col]);
                if (activityArray[row][col] != null) {
                    System.out.println("Adding activities to list: " + activityArray[row][col]);
                    activityList.add(new Activity(activityArray[row][col], row, col));
                }
            }
        }
        System.out.println(activityList.size());
        ObservableList<Activity> observableActivityList = FXCollections.observableArrayList(activityList);
        System.out.println(observableActivityList.size());
        activityListView.setItems(observableActivityList);
        activityListView.setCellFactory(listView -> new ActivityListViewCell());
        //timetableListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //logger.fine("Selection in event list panel changed to : '" + newValue + "'");
            //onSelectedEventChange.accept(newValue);
        //});
        //        selectedEvent.addListener((observable, oldValue, newValue) -> {
        //            logger.fine("Selected event changed to: " + newValue);
        //
        //            // Don't modify selection if we are already selecting the selected event,
        //            // otherwise we would have an infinite loop.
        //            if (Objects.equals(eventListView.getSelectionModel().getSelectedItem(), newValue)) {
        //                return;
        //            }
        //
        //            if (newValue == null) {
        //                eventListView.getSelectionModel().clearSelection();
        //            } else {
        //                int index = eventListView.getItems().indexOf(newValue);
        //                eventListView.scrollTo(index);
        //                eventListView.getSelectionModel().clearAndSelect(index);
        //            }
        //        });
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Event} using a {@code EventCard}.
     */
    class ActivityListViewCell extends ListCell<Activity> {
        @Override
        protected void updateItem(Activity activity, boolean empty) {
            super.updateItem(activity, empty);

            if (empty || activity == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ActivityCard(activity, getIndex() + 1).getRoot());
            }
        }
    }

}
