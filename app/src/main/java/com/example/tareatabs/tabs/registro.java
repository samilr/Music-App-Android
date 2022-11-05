package com.example.tareatabs.tabs;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tareatabs.R;


public class registro extends Fragment {
    EditText txbNombre, txbApellido, txbTelefono, txbEmail, txbPassword1, txbPassword2;
    FrameLayout flRegistro, flafterRegister, flafterRegister2;
    Button btnRegistrar,btnVerInfo;
    TextView txtUser, txtNombre, txtApellido, txtTelefono, txtEmail, txtNameForm;
    String name, lastName, email, phoneNumber, password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        txbNombre = view.findViewById(R.id.txbName);
        txbApellido = view.findViewById(R.id.txbLastName);
        txbTelefono = view.findViewById(R.id.txbTelefono);
        txbEmail = view.findViewById(R.id.txbEmail);
        txbPassword1 = view.findViewById(R.id.txbPassword1);
        txbPassword2 = view.findViewById(R.id.txbPassword2);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);
        btnVerInfo = view.findViewById(R.id.btnVerInfo);
        flRegistro = view.findViewById(R.id.flRegistro);
        txtNameForm = view.findViewById(R.id.txtNameForm);
        flafterRegister = view.findViewById(R.id.flafterRegister);
        flafterRegister2 = view.findViewById(R.id.flafterRegister2);
        flafterRegister.setVisibility(View.INVISIBLE);
        flafterRegister2.setVisibility(View.INVISIBLE);
        saludo();


        btnRegistrar.setOnClickListener(v -> {
            final  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            if ((txbNombre.getText().length() < 1) || (txbApellido.getText().length() < 1) || (txbTelefono.getText().length()
                    < 1) && (txbEmail.getText().length() < 1) || (txbPassword1.getText().length() < 1) || (txbPassword2.getText().length() < 1)) {
                builder.setMessage("Por favor complete todos los campos")
                        .setPositiveButton("ok", (dialog, id) -> dialog.cancel());
            }
            else if (!txbPassword1.getText().toString().equals(txbPassword2.getText().toString())) {
                builder.setMessage("Las contraseñas no coinciden.")
                        .setPositiveButton("ok", (dialog, id) -> dialog.cancel());
            }
            else {
                builder.setMessage("Usuario Registrado Exitosamente!!")
                        .setPositiveButton("ok", (dialog, id) -> dialog.cancel());

                name = txbNombre.getText().toString();
                phoneNumber = txbTelefono.getText().toString();
                email = txbEmail.getText().toString();
                lastName = txbApellido.getText().toString();
                password = txbPassword1.getText().toString();
                hideRegistrerForm(true);
            }
            builder.create();
            builder.show();
        });

        btnVerInfo.setOnClickListener(v -> {
            final  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            final View vistaAlertEdit = inflater.inflate(R.layout.activity_user_info, null);

            txtUser = vistaAlertEdit.findViewById(R.id.txtUser);
            txtNombre = vistaAlertEdit.findViewById(R.id.txtName);
            txtApellido = vistaAlertEdit.findViewById(R.id.txtApellido);
            txtEmail = vistaAlertEdit.findViewById(R.id.txtEmail);
            txtTelefono = vistaAlertEdit.findViewById(R.id.txtTelefono);

            txtUser.setText("¡Hola "+name+"!");
            txtNombre.setText(name);
            txtApellido.setText(lastName);
            txtEmail.setText(email);
            txtTelefono.setText(phoneNumber);

            builder.setView(vistaAlertEdit).setTitle("Informacion de usuario")
                    .setNegativeButton("Cerrar", (dialog, which) -> dialog.cancel());
            builder.create();
            builder.show();
        });
        return view;
    }

    public void hideRegistrerForm(Boolean registred){
        if (registred){
            flRegistro.setVisibility(View.INVISIBLE);
            flafterRegister.setVisibility(View.VISIBLE);
            flafterRegister2.setVisibility(View.VISIBLE);
            txtNameForm.setText("Que gusto "+name);
        }
    }
    public void saludo(){
        Toast.makeText(getActivity(), "Estas en Registro.",
                Toast.LENGTH_SHORT).show();
    }

}