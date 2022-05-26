package com.example.coursegeo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.coursegeo.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;


public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    private long backPressedTime;

    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);

        root = findViewById(R.id.root_element);


        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btnRegister.setOnClickListener(new View.OnClickListener() { // Обработчик событий кнопки button register
            @Override
            public void onClick(View view) {
                showRegisterWindow();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() { // Обработчик событий кнопки button register
            @Override
            public void onClick(View view) {
                showSignInWindow();
            }
        });
    }

    // Системная кнопка начало

    @Override
    public void onBackPressed() {


        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    // Системная кнопка конец

    private void showSignInWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);  // AlertDialog специальный класс , который помогает создавать всплывающие окна
        dialog.setTitle("Войти");
        dialog.setMessage("Введите данные для входа");

        LayoutInflater inflater = LayoutInflater.from(this); // Создали объект на основе класса LayoutInflater ( Для получения шаблона sign_in window)
        View sign_in_window = inflater.inflate(R.layout.sign_in_window, null);  // Получение шаблона . Шаблон идёт на основе класс view.
        dialog.setView(sign_in_window); // setView позволяет установить внутренний шаблон

        final MaterialEditText email = sign_in_window.findViewById(R.id.emailField);
        final MaterialEditText pass = sign_in_window.findViewById(R.id.passField);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss(); // dismiss означает , что данное которое всплывает будет скрыто
            }
        });  // Функция, позволяющая установить кнопку отмены / Первый параметр мы указываем , что должно быть написано на кнопке , вторым параметром функция которая сработает при нажатии на эту кнопку

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(email.getText().toString())) { // TextUtils позволяет нам использовать функцию isEmpty , которая определяет пустая ли строка
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show(); // Класс позволяет выводить различные ошибки в всплывающих окнах . make выводит окно
                    return; // Нужен для того, чтобы мы сразу выхоидил из функции после ошибки и никакой код не обрабатывался
                }

                if (pass.getText().toString().length() < 5) {
                    Snackbar.make(root, "Введите пароль, который более 5 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            startActivity(new Intent(MainActivity.this, navigateActivity.class));
                            finish();            // Завершает данную сцену и будет совершён переход на новую
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка авторизации" + e.getMessage(), Snackbar.LENGTH_SHORT).show();  // e.getMessage() для вывода ошибки
                    }
                });
            }
        });

        dialog.show();
    }

    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);  // AlertDialog специальный класс , который помогает создавать всплывающие окна
        dialog.setTitle("Зарегистрироваться");
        dialog.setMessage("Введите все данные для регистриграции");


        LayoutInflater inflater = LayoutInflater.from(this); // Создали объект на основе класса LayoutInflater ( Для получения шаблона регистер window)
        View register_window = inflater.inflate(R.layout.register_window, null);  // Получение шаблона . Шаблон идёт на основе класс view.
        dialog.setView(register_window); // setView позволяет установить внутренний шаблон

        final MaterialEditText email = register_window.findViewById(R.id.emailField);
        final MaterialEditText pass = register_window.findViewById(R.id.passField);
        final MaterialEditText name = register_window.findViewById(R.id.nameField);
        final MaterialEditText phone = register_window.findViewById(R.id.phoneField);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss(); // dismiss означает , что данное которое всплывает будет скрыто
            }
        });  // Функция, позволяющая установить кнопку отмены / Первый параметр мы указываем , что должно быть написано на кнопке , вторым параметром функция которая сработает при нажатии на эту кнопку

        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(email.getText().toString())) { // TextUtils позволяет нам использовать функцию isEmpty , которая определяет пустая ли строка
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show(); // Класс позволяет выводить различные ошибки в всплывающих окнах . make выводит окно
                    return; // Нужен для того, чтобы мы сразу выхоидил из функции после ошибки и никакой код не обрабатывался
                }
                if (TextUtils.isEmpty(name.getText().toString())) {
                    Snackbar.make(root, "Введите ваше имя", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone.getText().toString())) {
                    Snackbar.make(root, "Введите ваш телефон", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (pass.getText().toString().length() < 5) {
                    Snackbar.make(root, "Введите пароль, который более 5 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // Регистрация пользователя
                auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {   // Обработчик события, который вызовет onSuccess только в том случае, если у нас пользователь был успешно добавлен в бд
                                User user = new User();
                                user.setEmail(email.getText().toString());
                                user.setName(name.getText().toString());
                                user.setPass(pass.getText().toString());
                                user.setPhone(phone.getText().toString());

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())// В табличке Users добавил setValue(user) ( НОВОГО ПОЛЬЗОВАТЕЛЯ и указал для него все данные ), а также дополнительно указал , что ключ по которому мы аундефицируем юзера это id определённой записи
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(root, "Пользователь добавлен", Snackbar.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Snackbar.make(root, "Ошибка регистрации" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                                    }
                                });
                            }
                        });

            }
        });

            dialog.show(); // Чтобы показывать всплывающее окно

    }
}