package pt.ipbeja.PAC_Project.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import pt.ipbeja.PAC_Project.models.Cart;
import pt.ipbeja.PAC_Project.models.Category;
import pt.ipbeja.PAC_Project.models.Component;
import pt.ipbeja.PAC_Project.models.Favourite;
import pt.ipbeja.PAC_Project.models.ReserveComponent;
import pt.ipbeja.PAC_Project.models.UserComponent;
import pt.ipbeja.PAC_Project.models.UserLogin;

@Database(entities = {Category.class ,Component.class, Cart.class, Favourite.class, UserComponent.class, UserLogin.class, ReserveComponent.class},
version = 1, exportSchema = false)

public abstract class AppDataBase extends RoomDatabase {

    public abstract DatabaseDAO databaseDAO();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "dbOscarXavier")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            db.execSQL("INSERT INTO UserLogin (userName, userPass, firstName, lastName, email, userType)" +
                                       "VALUES ('alface', 'alface22', 'alface', 'alface', 'alface', 1);");

                            db.execSQL("INSERT INTO Category (category, designation)" +
                                    "VALUES ('CAT_01', 'Motor')," +
                                    "('CAT_02', 'Pneus')," +
                                    "('CAT_03', 'xapa')," +
                                    "('CAT_04', 'teste');");

                            db.execSQL("INSERT INTO Favourite (idUser, idComp, flagFavourite)" +
                                    "VALUES (1, 1, 1)," +
                                    "(1, 3, 1)," +
                                    "(1, 2, 1)," +
                                    "(1, 5, 1);");

                            db.execSQL("INSERT INTO Cart (idUser, idComp, flagCart)" +
                                    "VALUES (1, 1, 1)," +
                                    "(1, 3, 1)," +
                                    "(1, 2, 1)," +
                                    "(1, 5, 1);");

                            db.execSQL("INSERT INTO Component (designation, idCategory , price)" +
                                    "VALUES ('Motor Renault DCI', 1 , '1372.67')," +
                                    "('Motor Ecotec 1.2 Opel corsa', 1 , '1542.41')," +
                                    "('Motor Mercedes-Benz c-class coupe (CL203) C 220 CDI', 1 , '1642.04')," +
                                    "('Motor Honda Civic IX 1.8 I-VTEC - 1027.04', 1 , '1027.04')," +
                                    "('Motor volkswagen Golf V (1K1) 1.9 TDI', 1 , '1309.94')," +
                                    "('Yokohama BluEarth-Es ES32 205/55 R16 91V', 2 , '50.39')," +
                                    "('Pirelli Cinturato P7 205/55 R16 91V', 2 , '57.59')," +
                                    "('Michelin Primacy 4 205/55 R16 91V', 2 , '74.99')," +
                                    "('Bridgestone Potenza S001', 2, '78.39')," +
                                    "('Continental ContiPremiumContact 2 E', 2 , '71.50')," +
                                    "('ABAKUS Jogo de faróis de nevoeiro', 3 , '82.88')," +
                                    "('DIEDERICHS Luz traseira à direita , sem porta-lâmpadas', 3 , '29.02')," +
                                    "('DIEDERICHS Luz traseira √† esquerda, sem porta-l√Ęmpadas', 3 , '29.02')," +
                                    "('ALKAR Retrovisor exterior à direita, mecânico, convexo', 3 , '35.30')," +
                                    "('ALKAR Retrovisor exterior à direita, mecânico, convexo', 3 , '35.30')," +
                                    "('ABAKUS Jogo de faróis de nevoeiro', 4 , '82.88')," +
                                    "('DIEDERICHS Luz traseira à direita , sem porta-lâmpadas', 4 , '29.02')," +
                                    "('DIEDERICHS Luz traseira √† esquerda, sem porta-l√Ęmpadas', 4 , '29.02')," +
                                    "('ALKAR Retrovisor exterior à direita, mecânico, convexo', 4 , '35.30')," +
                                    "('ALKAR Retrovisor exterior à direita, mecânico, convexo', 4 , '35.30')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }


//    public static AppDataBase getINSTANCE(final Context context) {
//
//        if (INSTANCE == null)
//        {
//            synchronized (AppDataBase.class)
//            {
//                if (INSTANCE == null)
//                {
//                   INSTANCE = buildDatabase(context);
//                }
//            }
//        }
//
//        return INSTANCE;
//    }
//
//    private static AppDataBase buildDatabase(final Context context){
//        return Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class, "dbOscarXavier")
//                .addCallback(new Callback(){
//                    @Override
//                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                        super.onCreate(db);
//
//
//                            db.execSQL("INSERT INTO Component (designation, price, category)" +
//                                    "VALUES ('Motor Renault DCI', '1372.67', 'CAT_01')," +
//                                    "('Motor Ecotec 1.2 Opel corsa', '1542.41', 'CAT_01')," +
//                                    "('Motor Mercedes-Benz c-class coupe (CL203) C 220 CDI', '1642.04', 'CAT_01')," +
//                                    "('Motor Honda Civic IX 1.8 I-VTEC - 1027.04', '1027.04', 'CAT_01')," +
//                                    "('Motor volkswagen Golf V (1K1) 1.9 TDI', '1309.94', 'CAT_01')," +
//                                    "('Yokohama BluEarth-Es ES32 205/55 R16 91V', '50.39', 'CAT_02')," +
//                                    "('Pirelli Cinturato P7 205/55 R16 91V', '57.59', 'CAT_02')," +
//                                    "('Michelin Primacy 4 205/55 R16 91V', '74.99', 'CAT_02')," +
//                                    "('Bridgestone Potenza S001', '78.39', 'CAT_02')," +
//                                    "('Continental ContiPremiumContact 2 E', '71.50', 'CAT_02')," +
//                                    "('ABAKUS Jogo de faróis de nevoeiro', '82.88', 'CAT_03')," +
//                                    "('DIEDERICHS Luz traseira à direita , sem porta-lâmpadas', '29.02', 'CAT_03')," +
//                                    "('DIEDERICHS Luz traseira √† esquerda, sem porta-l√Ęmpadas', '29.02', 'CAT_03')," +
//                                    "('ALKAR Retrovisor exterior à direita, mecânico, convexo', '35.30', 'CAT_03')," +
//                                    "('ALKAR Retrovisor exterior à direita, mecânico, convexo', '35.30', 'CAT_03')");
//
//                    }
//                })
//                .allowMainThreadQueries()
//                .build();
//    }

}
