package github.tornaco.xposedmoduletest.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import github.tornaco.xposedmoduletest.bean.BlockRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BLOCK_RECORD".
*/
public class BlockRecordDao extends AbstractDao<BlockRecord, Integer> {

    public static final String TABLENAME = "BLOCK_RECORD";

    /**
     * Properties of entity BlockRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Integer.class, "id", true, "ID");
        public final static Property PkgName = new Property(1, String.class, "pkgName", false, "PKG_NAME");
        public final static Property AppName = new Property(2, String.class, "appName", false, "APP_NAME");
        public final static Property TimeWhen = new Property(3, Long.class, "timeWhen", false, "TIME_WHEN");
        public final static Property HowManyTimes = new Property(4, Long.class, "howManyTimes", false, "HOW_MANY_TIMES");
        public final static Property Allow = new Property(5, Boolean.class, "allow", false, "ALLOW");
        public final static Property Description = new Property(6, String.class, "description", false, "DESCRIPTION");
        public final static Property Why = new Property(7, String.class, "why", false, "WHY");
    };


    public BlockRecordDao(DaoConfig config) {
        super(config);
    }
    
    public BlockRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BLOCK_RECORD\" (" + //
                "\"ID\" INTEGER PRIMARY KEY ," + // 0: id
                "\"PKG_NAME\" TEXT," + // 1: pkgName
                "\"APP_NAME\" TEXT," + // 2: appName
                "\"TIME_WHEN\" INTEGER," + // 3: timeWhen
                "\"HOW_MANY_TIMES\" INTEGER," + // 4: howManyTimes
                "\"ALLOW\" INTEGER," + // 5: allow
                "\"DESCRIPTION\" TEXT," + // 6: description
                "\"WHY\" TEXT);"); // 7: why
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BLOCK_RECORD\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, BlockRecord entity) {
        stmt.clearBindings();
 
        Integer id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String pkgName = entity.getPkgName();
        if (pkgName != null) {
            stmt.bindString(2, pkgName);
        }
 
        String appName = entity.getAppName();
        if (appName != null) {
            stmt.bindString(3, appName);
        }
 
        Long timeWhen = entity.getTimeWhen();
        if (timeWhen != null) {
            stmt.bindLong(4, timeWhen);
        }
 
        Long howManyTimes = entity.getHowManyTimes();
        if (howManyTimes != null) {
            stmt.bindLong(5, howManyTimes);
        }
 
        Boolean allow = entity.getAllow();
        if (allow != null) {
            stmt.bindLong(6, allow ? 1L: 0L);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(7, description);
        }
 
        String why = entity.getWhy();
        if (why != null) {
            stmt.bindString(8, why);
        }
    }

    /** @inheritdoc */
    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public BlockRecord readEntity(Cursor cursor, int offset) {
        BlockRecord entity = new BlockRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // pkgName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // appName
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // timeWhen
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // howManyTimes
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // allow
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // description
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // why
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, BlockRecord entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setPkgName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAppName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTimeWhen(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setHowManyTimes(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setAllow(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setDescription(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setWhy(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Integer updateKeyAfterInsert(BlockRecord entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public Integer getKey(BlockRecord entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
