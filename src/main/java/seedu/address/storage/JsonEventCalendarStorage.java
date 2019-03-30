package seedu.address.storage;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyEventCalendar;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonEventCalendarStorage implements EventCalendarStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonEventCalendarStorage.class);

    private Path filePath;

    public JsonEventCalendarStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getEventCalendarFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyEventCalendar> readEventCalendar() throws DataConversionException {
        return readEventCalendar(filePath);
    }

    /**
     * Similar to {@link #readEventCalendar()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyEventCalendar> readEventCalendar(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableEventCalendar> jsonEventCalendar= JsonUtil.readJsonFile(
                filePath, JsonSerializableEventCalendar.class);
        if (!jsonEventCalendar.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonEventCalendar.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveEventCalendar(ReadOnlyEventCalendar eventCalendar) throws IOException {
        saveEventCalendar(eventCalendar, filePath);
    }

    /**
     * Similar to {@link #saveEventCalendar(ReadOnlyEventCalendar)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveEventCalendar(ReadOnlyEventCalendar eventCalendar, Path filePath) throws IOException {
        requireNonNull(eventCalendar);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableEventCalendar(eventCalendar), filePath);
    }

}
