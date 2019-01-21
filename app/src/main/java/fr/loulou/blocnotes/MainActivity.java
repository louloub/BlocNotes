package fr.loulou.blocnotes;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.RadioButton;

import static fr.loulou.blocnotes.R.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Création des bouttons
    ImageButton B1;
    ImageButton B2;
    ImageButton B3;
    ImageButton B4;
    ImageButton S1;
    ImageButton S2;
    ImageButton S3;
    RadioButton Noir;
    RadioButton Bleu;
    RadioButton Rouge;
    EditText editText;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        // Création du lien entre le bouton (code) et le bouton (visuel XML)
        B1 = findViewById(id.b1);
        B2 = findViewById(id.b2);
        B3 = findViewById(id.b3);
        B4 = findViewById(id.b4);
        S1 = findViewById(id.s1);
        S2 = findViewById(id.s2);
        S3 = findViewById(id.s3);
        Noir = this.<RadioButton>findViewById(id.Noir);
        Bleu = findViewById(id.Bleu);
        Rouge = findViewById(id.Rouge);
        editText = findViewById(id.editText);
        textView4 = findViewById(id.textView4);

        // Création d'un "listener" par boutton en utilisant la methode "OnClick"
        // On utilise "This" car on à immplémenté "implements View.OnClickListener" dans la "main-activity"
        // On a créé au préalable la methode "onClick"
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        B3.setOnClickListener(this);
        B4.setOnClickListener(this);
        S1.setOnClickListener(this);
        S2.setOnClickListener(this);
        S3.setOnClickListener(this);
        Noir.setOnClickListener(this);
        Bleu.setOnClickListener(this);
        Rouge.setOnClickListener(this);
        editText.setOnClickListener(this);
        textView4.setOnClickListener(this);

        // Interpretation de "TextView" en fonction "EditText"
        // La méthode est "addTextChangeListener"
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            /**
             * s est la chaîne de caractères qui est en train de changer
             */
            // "CharSequence s" etc sont les paramètres de la méthode, ce qu'on peut utiliser dedans
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Que faire au moment où le texte change ?
                // inserer le "s" dans le textview

                textView4.setText(s);
            }

            @Override
            /**
             * @param s La chaîne qui a été modifiée
             * @param count Le nombre de caractères concernés
             * @param start L'endroit où commence la modification dans la chaîne
             * @param after La nouvelle taille du texte
             */
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            /**
             * @param s L'endroit où le changement a été effectué
             */
            public void afterTextChanged(Editable s) {
                // Que faire juste après que le changement de texte a été pris en compte ?
            }
        });

        // CLICK SUR B1 REND LE TEXTE GRAS
        // La méthode est "setOnClickListener"
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }
        });

        // CLICK SUR B1 REND LE TEXTE ITALIQUE
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            }
        });

        // CLICK SUR B1 REND LE TEXTE NORMAL
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        });

        // CLICK SUR NOIR REND LE TEXTE NOIR
        Noir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTextColor(Color.BLACK);
            }
        });

        // CLICK SUR ROUGE REND LE TEXTE ROUGE
        Rouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTextColor(Color.RED);
            }
        });

        // CLICK SUR BLEU REND LE TEXTE BLEU
        Bleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTextColor(Color.BLUE);
            }
        });

        // CLICK SUR S1 AJOUTER LE SMYLE DANS LE EDIT VIEW
        S1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                // convertion de INT a DRAWABLE pour etre accépté dans la méthode setCompount...
                Drawable s1 = getDrawable(drawable.s1);
                textView4.setCompoundDrawablesWithIntrinsicBounds(null, null, s1, null);
                textView4.setCompoundDrawablePadding(10);
            }
        });

        // CLICK SUR S2 AJOUTER LE SMYLE DANS LE EDIT VIEW
        S2.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                // convertion de INT a DRAWABLE pour etre accépté dans la méthode setCompount...
                Drawable s2 = getDrawable(drawable.s2);
                textView4.setCompoundDrawablesWithIntrinsicBounds(null, null, s2, null);
                textView4.setCompoundDrawablePadding(10);
            }
        });

        // CLICK SUR S3 AJOUTER LE SMYLE DANS LE EDIT VIEW
        S3.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                // convertion de INT a DRAWABLE pour etre accépté dans la méthode setCompount...
                Drawable s3 = getDrawable(drawable.s3);
                textView4.setCompoundDrawablesWithIntrinsicBounds(null, null, s3, null);
                textView4.setCompoundDrawablePadding(10);
            }
        });

        /*
        // TEST TRANLSATION EN APPUYANT SUR LE B4
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, anim.translation);
                B4.startAnimation(animation);
            }

            public void on(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, anim.translationinverse);
                B4.startAnimation(animation);
            }
        });
        */

        /*
        // TEST TRANLSATION EN APPUYANT SUR LE B4
        B4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                B4.startAnimation(toggle(true));
            }
        });
        */

        /*
        // ACTION SUR LE BOUTON B1 (fonctionne)
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "test", LENGTH_SHORT).show();
            }
        });
        */


    }

    @Override
    public void onClick(View v) {

    }

    // Methode pour les "RadioButton"
    public void onRadioButtonClicked(View view) {
    }

    public void onImageButtonClicked(View view) {

    }
}