/*
 * Licence is provided in the jar as license.yml also here:
 * https://github.com/Rsl1122/Plan-PlayerAnalytics/blob/master/Plan/src/main/resources/license.yml
 */
package com.djrapitops.plan.system.database;

import com.djrapitops.plan.api.exceptions.DatabaseInitException;
import com.djrapitops.plan.system.database.databases.MySQLDB;
import com.djrapitops.plan.system.database.databases.SQLiteDB;
import com.djrapitops.plan.system.settings.Settings;

/**
 * //TODO Class Javadoc Comment
 *
 * @author Rsl1122
 */
public class BukkitDBSystem extends DBSystem {

    @Override
    protected void initDatabase() throws DatabaseInitException {
        databases.add(new MySQLDB());
        databases.add(new SQLiteDB());

        String dbType = Settings.DB_TYPE.toString().toLowerCase().trim();
        db = getActiveDatabase(dbType);
        db.init();
    }
}