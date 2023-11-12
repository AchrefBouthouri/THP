package com.thp.tunisianhiddenplaces.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.thp.tunisianhiddenplaces.domain.Utilisateur;

public class THPDB extends SQLiteOpenHelper {
        private static final String NOM_BASE_DE_DONNEES = "THP";
        private static final int VERSION = 1;

        private static final String TABLE_UTILISATEURS = "utilisateurs";
        private static final String COL_USERNAME = "username";
        private static final String COL_EMAIL = "email";
        private static final String COL_PASSWORD = "password";

        public THPDB(Context context) {
            super(context, NOM_BASE_DE_DONNEES, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE_UTILISATEURS = "CREATE TABLE " + TABLE_UTILISATEURS + "("
                    + COL_USERNAME + " TEXT PRIMARY KEY,"
                    + COL_EMAIL + " TEXT,"
                    + COL_PASSWORD + " TEXT" + ")";
            db.execSQL(CREATE_TABLE_UTILISATEURS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTILISATEURS);
            onCreate(db);
        }

        // Méthode pour ajouter un utilisateur à la base de données
        public void ajouterUtilisateur(Utilisateur utilisateur) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_USERNAME, utilisateur.getUsername());
            values.put(COL_EMAIL, utilisateur.getEmail());
            values.put(COL_PASSWORD, utilisateur.getPassword());
            db.insert(TABLE_UTILISATEURS, null, values);
            db.close();
        }

        // Méthode pour vérifier si un utilisateur existe dans la base de données
        public boolean verifierUtilisateur(String username, String password) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_UTILISATEURS,
                    new String[]{COL_USERNAME, COL_PASSWORD},
                    COL_USERNAME + "=? AND " + COL_PASSWORD + "=?",
                    new String[]{username, password}, null, null, null, null);
            boolean utilisateurExiste = cursor != null && cursor.getCount() > 0;
            if (cursor != null) cursor.close();
            return utilisateurExiste;
        }
    }
