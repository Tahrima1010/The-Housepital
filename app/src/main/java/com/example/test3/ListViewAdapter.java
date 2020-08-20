package com.example.test3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//If  data source is an ArrayList or array then we can
// also use the ArrayAdapter construct as an alternative.
// ** list items are automatically inserted into the list using an adapter that is connected to a source


public class ListViewAdapter extends BaseAdapter {

    Context mcontext;//context
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arraylist;// //data source of the list adapter

    //constructor
    public ListViewAdapter(Context context, ArrayList<Model> modellist) {
        mcontext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mcontext);
        this.arraylist = new ArrayList<Model>();
        this.arraylist.addAll(modellist);
    }
    //The aim of the ViewHolder pattern, is to reduce the number of findViewById calls in the adapter's getView.
    //holds direct references to all inner views from a row
    public class ViewHolder {
        TextView mtitletv, mdeccriptiontv;
        ImageView micontv;
    }

    @Override
    public int getCount() {

        return modellist.size();//returns total of items in the list
    }

    @Override
    public Object getItem(int position) {

        return modellist.get(position);//returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertview , ViewGroup parent) {
        ViewHolder holder;
        // inflate the layout for each list row
        if (convertview == null) {
            holder = new ViewHolder();
            convertview = LayoutInflater.from(mcontext).
                    inflate(R.layout.row, parent, false);
            // convertview = inflater.inflate(R.layout.row, null);
            // get the TextView for item name ,item description and get imageview for  image
            holder.mtitletv = convertview.findViewById(R.id.maintitle);
            holder.mdeccriptiontv = convertview.findViewById(R.id.maindescription);

            holder.micontv = convertview.findViewById(R.id.mainIcon);

            convertview.setTag(holder);//It is then stored as a tag in the row's view after inflating it
        } else {
            holder = (ViewHolder) convertview.getTag();//recycle
        }
        //set the result into textview
        holder.mtitletv.setText(modellist.get(position).getTitle());
        holder.mdeccriptiontv.setText(modellist.get(position).getDescription());
        //set the result in image view
        holder.micontv.setImageResource(modellist.get(position).getIcon());

        //listview item click
        convertview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(modellist.get(position).getTitle().equals("Heart Failure")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                    //  intent.putExtra("actionBarTitle","Heart Failure");
                    intent.putExtra("contentTv","SYMPTOMS OF HEART FAILURE : \n" +
                            "\n" +
                            "1.Breathlessness.\n" +
                            "2.Tiredness and lethargy.\n" +
                            "3.Leg swelling.\n" +
                            "4.Loss of appetite.\n" +
                            "\n" +"\n" +
                            "REASONS OF HEART FAILURE : \n" +
                            "\n" +
                            "Conditions that can cause heart failure include:\n" +
                            "\n" +
                            "1.Heart attack (coronary heart disease).\n" +
                            "2.Inherited heart disease (for example, cardiomyopathy)\n" +
                            "3.High blood pressure (hypertension).\n" +
                            "4.Heart rhythm or valve abnormalities.\n" +
                            "5.Viral infection and damage from the immune system (myocarditis).\n" +
                            "\n" +"\n" +
                            "REMEDY OF HEART FAILURE : \n" +
                            "\n" +
                            "1.Avoid smoking.\n" +
                            "2.Avoid drinking excessive amounts of alcohol.\n" +
                            "3.Take regular exercise.\n" +
                            "4.Eat a healthy diet .\n" +
                            "5.Immunisations.\n" +
                            "6.If you have high blood pressure, maintain good control of it.\n" +
                            "7.If you are diabetic, maintain good control of it and always attend review appointments.\n" +
                            "\n" + "\n" +
                            "Many treatments available can help to keep the condition under control and help to relieve the symptoms.Some" +
                            "of them as following :\n" +"\n" +
                            "1.Medicines\n" +
                            "2.Heart transplant.\n" +
                            "3.Mental wellbeing.\n" +
                            "4.Immunisations.\n");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Jondish")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Jondish ");
                    intent.putExtra("contentTv","SYMPTOMS OF Jaundice  : \n" +
                            "\n" +
                            "1.A yellow tinge to the skin and the whites of the eyes, normally starting at the head and spreading down the body\n" +
                            "2.Pale stools\n" +
                            "3.Dark urine\n" +
                            "4.Itchiness\n" +
                            "5.Fatigue\n" +
                            "6.Abdominal pain\n" +
                            "7.Weight loss\n" +
                            "8.Vomiting\n" +
                            "9.Fever\n" +
                            "10.Pale stools\n" +
                            "11.dark urine\n" +
                            "\n" + "\n" +
                            "REASONS OF  JAUNDICE : \n" +
                            "\n" +
                            "1.Acute inflammation of the liver\n" +
                            "2.Inflammation of the bile duct\n" +
                            "3.Obstruction of the bile duct\n" +
                            "4.Hemolytic anemia\n" +
                            "5.Gilbert’s syndrome\n" +
                            "6.Cholestasis\n" +
                            "\n" +"\n" +
                            "REMEDY OF JAUNDICE : \n " +
                            "\n" +
                            "Jaundice is related to liver function. It is essential that people maintain the health of this vital organ by eating a balanced diet, exercising regularly, " +
                            "and not consuming more than the recommended amounts of alcohol.\n" +
                            "\n" +"\n" +
                            "The following treatments are used:\n" +
                            "\n" +
                            "1.Anemia-induced jaundice may be treated by boosting the amount of iron in the blood by either taking iron supplements or eating more iron-rich foods. Iron supplements are available for purchase online.\n" +
                            "2.Hepatitis-induced jaundice requires antiviral or steroid medications.\n" +
                            "3.Doctors can treat obstruction-induced jaundice by surgically removing the obstruction.\n" +
                            "4.If the jaundice has been caused by use of a medication, treatment for" +
                            " involves changing to an alternative medication.\n");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("kidney cancer")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","kidney cancer");
                    intent.putExtra("contentTv"," SYMPTOMS OF KIDNEY CANCER  : \n" +

                            "\n" +
                            "1. Extreme tiredness (fatigue) or anaemia\n" +
                            "2. Unintentional weight loss\n" +
                            "3 .A high temperature of 38C (100.4F) or above\n" +
                            "4 .Night sweats \n" +
                            "5 .A general sense of feeling unwell\n" +
                            "6 .Blood in your urine \n" +
                            "7 .Loss of appetite\n" +
                            "8 .High blood pressure (hypertension)\n" +
                            " 9 .A persistent pain in your side, just below the ribs\n" +
                            "\n" +"\n" +
                            " REASONS OF KEDNEY CANCER : \n" +
                            "\n" +
                            "The exact cause of kidney cancer is unknown, but there are risk factors that can increase the chances of developing the condition" +
                            "The three main risk factors for kidney cancer are:\n" +
                            "\n" +
                            " * obesity\n" +
                            " * smoking\n" +
                            " * family history and genetics\n" +
                            "\n" +"\n" +
                            " REMEDY OF KEDNEY CANCER  : \n" +
                            "\n" +
                            "As the causes of kidney cancer aren't fully understood, it's not possible to completely prevent it.\n" +
                            "\n" +
                            "However, leading a healthy lifestyle may help reduce your chances of developing the condition.\n" +
                            "\n" +
                            "1)Diet\n " +
                            "\n"+
                            "Avoid eating foods high in saturated fat because it will increase your cholesterol level.such as - cream,butter,cakes and biscuits,foods that contain coconut or palm oil \n" +
                            "\n" +
                            "2)Exercise\n" +
                            "\n" +
                            "The exercise should be strenuous enough to increase your heart rate and you should feel slightly out of breath afterwards.your exercise programme include:\n" +
                            "\n" +
                            "brisk walking\n" +
                            "hill climbing\n" +
                            "running \n" +
                            "cycling\n" +
                            "swimming \n " +
                            "\n" +
                            "3)Giving up smoking\n" +
                            "\n" +
                            "If you smoke, giving up is the most effective way of preventing kidney cancer, as well as a number of other serious health conditions, such as stroke, heart attack and lung cancer.\n " +
                            "\n" +
                            "4)Alcohol\n" +
                            "\n" +
                            "There's evidence to suggest that drinking a moderate amount of alcohol, such as 4-5 glasses of wine a month, will help reduce your risk of developing kidney cancer. The reasons for this aren't fully understood .\n"
                            + "\n" +"\n" +
                            "THE MAIN TREATMENTS FOR KEDNY CANCER ARE COVERED IN DETAIL BELOW AND INCLUDE :\n" +
                            "\n" +
                            "** Nephrectomy\n" +
                            "** Embolisation\n" +
                            "** Radiotherapy \n" +
                            "** Targeted therapies \n" +
                            "** Immunotherapy.\n");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Migraine")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Migraine");
                    intent.putExtra("contentTv","SYMPTOMS OF MIGRAINE :\n" +
                            "\n" +
                            "The main symptom of a migraine is usually an intense headache on one side of the head.\n"
                            + "Other symptoms commonly associated with a migraine include:\n" +
                            "\n" +
                            "1.Nausea\n" +
                            "2.Vomiting\n" +
                            "3.Increased sensitivity to light and sound – which is why many people with a" +
                            " migraine want to rest in a quiet, dark room\n" +
                            "4.Sweating\n" +
                            "5.Poor concentration,\n" +
                            "6.Feeling very hot or very cold\n" +
                            "7.Abdominal (tummy) pain\n" +
                            "8.Diarrhoea.\n" + "\n" +
                            "****The symptoms of a migraine usually last between four hours and three days, although you " +
                            "may feel very tired for up to a week afterwards.****\n" +
                            "\n" +"\n" +
                            "REASONS OF MIGRAINE : \n"+
                            "\n" +
                            "1.Emotional triggers\n" +
                            "2.Physical triggers\n" +
                            "3.Hormonal changes\n" +
                            "4.Environmental triggers\n"+
                            "5.Dietary triggers\n" +
                            "6.Medication" +
                            "\n" +"\n" +
                            "REMEDY OF MIGRAINE : \n " +
                            "\n" +
                            "1.Identifying and avoiding triggers\n" +
                            "2.Medication and supplements\n" +
                            "3.Preventing menstrual-related migraines :  As these migraines are relatively predictable, it may be possible" +
                            " to prevent them using either non-hormonal or hormonal treatments.\n"
                            + "4.Acupuncture\n" +
                            "\n" +"\n" +
                            "There's currently no cure for migraines, although a number of " +
                            "treatments are available to help ease the symptoms.\n"
                            +"As followings :-\n" +
                            "1.Most people find that sleeping or lying in a darkened room is " +
                            "the best thing to do when having a migraine attack." +
                            "2.Painkillers\n" +
                            "3.Combination medicines : \n" +
                            "It can also be very effective to" +
                            " combine a triptan with another painkiller, such as ibuprofen.\n" +
                            "4.Anti-sickness medicines  :\n" +
                            "Anti-sickness medicines, known as anti-emetics, can successfully treat" +
                            " migraine in some people even if you don't experience nausea or vomiting\n" +
                            "5.Triptans  :\n" +
                            "If ordinary painkillers aren't helping to relieve your migraine symptoms, you should make an appointment to see your GP. They may recommend taking painkillers in addition to" +
                            " a type of medication called a triptan and possibly anti-sickness medication .\n");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Allergies")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                  //  intent.putExtra("actionBarTitle","Allergies");
                    intent.putExtra("contentTv","This is Allergies details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Corona Virus(Covid-19)")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Corona Virus(Covid-19)");
                    intent.putExtra("contentTv","This is Corona Virus(Covid-19) details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Chicken Pox")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                    // intent.putExtra("actionBarTitle","Chicken Pox");
                    intent.putExtra("contentTv","This is Chicken Pox details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Diabetes")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Diabetes");
                    intent.putExtra("contentTv","This is Diabetes details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Diarrhoea")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                    // intent.putExtra("actionBarTitle","Diarrhoea");
                    intent.putExtra("contentTv","This is Diarrhoea details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Ebola Virus Diseases")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Ebola Virus Diseases");
                    intent.putExtra("contentTv","This is Ebola Virus Diseases details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Eye Cancer")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   //  intent.putExtra("actionBarTitle","Eye Cancer");
                    intent.putExtra("contentTv","This is Eye Cancer details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Food Poisoning")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                  //  intent.putExtra("actionBarTitle","Food Poisoning");
                    intent.putExtra("contentTv","This is Food Poisoning details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Liver Cancer")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Liver Cancer");
                    intent.putExtra("contentTv","This is Liver Cancer details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Malaria")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                     // intent.putExtra("actionBarTitle","Malaria");
                    intent.putExtra("contentTv","This is Malaria details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Malnutrition")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                    //intent.putExtra("actionBarTitle","Malnutrition");
                    intent.putExtra("contentTv","This is Malnutrition details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Itching")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Itching");
                    intent.putExtra("contentTv","This is Itching details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("HIV")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                    // intent.putExtra("actionBarTitle","HIV");
                    intent.putExtra("contentTv","This is HIV details...");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Headaches")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                     //intent.putExtra("actionBarTitle","Headaches");
                    intent.putExtra("contentTv","" +
                            " In many cases, you can treat your headaches at home with over-the-counter painkillers " +
                            "and lifestyle changes, such as getting more rest and drinking enough fluids. \n " +
                            "\n" +"\n" +
                            " REASONS OF HEADACHES : \n"+
                            "1. Drinking too much alcohol\n" +
                            "2. A head injury or concussion\n" +
                            "3. A cold or flu\n" +
                            "4. Temporomandibular disorders – problems affecting the \"chewing\" muscles and the joints between the lower jaw and the base of the skull\n" +
                            "5. Sinusitis – inflammation of the lining of the sinuses\n" +
                            "6. Carbon monoxide poisoning\n" +
                            "7. Sleep apnoea.\n" +
                            "\n" +"\n" +
                            "If you're concerned that your headache might be serious, you should seek " +
                            "immediate medical advice.\n");
                    mcontext.startActivity(intent);
                }
                if(modellist.get(position).getTitle().equals("Hepatitis A,B,C")){
                    //start new activity with title for actionbar and text for textview
                    Intent intent=new Intent(mcontext,NewActivity.class);
                   // intent.putExtra("actionBarTitle","Hepatitis A,B,C");
                    intent.putExtra("contentTv","SYMPTOMS OF HEPATITIS A :\n" +
                            "\n" +
                            "1.Eeling tired and generally unwell\n" +
                            "2. Joint and muscle pain\n" +
                            "3. A mild fever – usually no higher than 39C (102.2F)\n" +
                            "4. Loss of appetite\n" +
                            "5. Feeling or being sick\n" +
                            "6. Pain in the upper-right part of your tummy\n" +
                            "7.A headache, sore throat and cough\n " +
                            "\n" +"\n" +
                            "SYMPTOMS OF HEPATITIS B :\n" +
                            "\n" +
                            "1.A general sense of feeling unwell\n" +
                            "2.Loss of appetite\n" +
                            "3.Feeling and being sick\n" +
                            "4.Diarrhoea\n" +
                            "5. Abdominal pain\n" +
                            "6. Yellowing of the skin and eyes (jaundice)\n" +
                            "7.Dark urine and pale, grey-coloured poo\n" +
                            "\n" +"\n" +
                            "SYMPTOMS OF HEPATITIS C:\n" +
                            "\n" +
                            "1.Flu-like symptoms, such as muscle aches and a high temperature (fever)\n" +
                            "2.Feeling tired all the time\n" +
                            "3.Loss of appetite\n" +
                            "4.Abdominal  pain\n" +
                            "5.Feeling and being sick\n" +
                            "\n" +"\n" +
                            "REASONS OF HEPATITIS A :\n" +
                            "\n" +
                            "Most infections occur in parts of the world" +
                            " where standards of sanitation and food hygiene are generally poor\n" +
                            "Hepatitis A is caused by the hepatitis A virus, which is spread" +
                            " in the poo of someone with the infection.\n" +
                            "\n" +"\n" +
                            "REASONS OF HEPATITIS B : \n "+
                            "\n" +
                            "Hepatitis B is an infection caused by the hepatitis B virus. The virus is found in" +
                            " the blood and bodily fluids of an infected person.\n" +
                            "\n" +"\n" +
                            "REASONS OF HEPATITIS C :\n "
                            +"\n" +
                            "1.Injecting drugs.\n"+
                            "2.Unprotected sex.\n"+
                            "3.Sharing toothbrushes, scissors and razors\n"+
                            "4.Tattooing and body piercing\n"
                            +"5.Needlestick injury\n" +
                            "\n" +"\n" +

                            "REMEDY  OF  HEPATITIS A :\n" +
                            "\n" +
                            " 1.Eat smaller, lighter meals to help reduce nausea and vomiting\n "+
                            "2.Avoid alcohol \n" +
                            "3.wearing loose clothing and avoiding hot baths\n" +
                            "\n" +"\n" +
                            "THE TREATMENTS  OF  HEPATITIS A :\n" +
                            "\n" +
                            "1.Take painkillers such as paracetamol or ibuprofen\n"+
                            "2.Get plenty of rest, especially during the initial stages .\n" +
                            "\n" +"\n" +
                            "THE TREATMENTS  OF  HEPATITIS B :\n" +
                            "\n" +
                            " Many people don't have any troublesome symptoms, but if you do feel unwell, it can help to:\n" +
                            "\n" +
                            "1.Get plenty of rest\n" +
                            "2.Take over-the-counter painkillers, such as paracetamol or ibuprofen, for abdominal pain\n"+
                            "3.maintain a cool, well-ventilated environment\n" +
                            "4.take medication\n" +
                            "\n" +"\n" +
                            "THE TREATMENTS  OF  HEPATITIS C :\n" +
                            "\n" +
                            "1.Making lifestyle changes to help prevent further damage to your liver and reduce the risk of spreading the infection\n" +
                            "2.Taking a combination of 2 or 3 medications to fight the " +
                            "virus – this is known as combination therapy.\n");
                    mcontext.startActivity(intent);
                }

            }
        });


        return convertview;
    }
    //filter
    public void filter(String charText)
    {
        charText=charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if(charText.length()==0)
        {
            modellist.addAll(arraylist);

        }
        else
        {
            for(Model model : arraylist)
            {
                if(model.getTitle().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    modellist.add(model);


                }
            }
        }
        notifyDataSetChanged();


    }
}

