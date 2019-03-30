package seedu.address.storage;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyEventCalendar;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Represents a storage for {@link seedu.address.model.EventCalendar}.
 */
public interface EventCalendarStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getEventCalendarFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyEventCalendar}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyEventCalendar> readEventCalendar() throws DataConversionException, IOException;

    /**
     * @see #getEventCalendarFilePath()
     */
    Optional<ReadOnlyEventCalendar> readEventCalendar(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyEventCalendar} to the storage.
     * @param eventCalendar cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveEventCalendar(ReadOnlyEventCalendar eventCalendar) throws IOException;

    /**
     * @see #saveEventCalendar(ReadOnlyEventCalendar)
     */
    void saveEventCalendar(ReadOnlyEventCalendar eventCalendar, Path filePath) throws IOException;

}
