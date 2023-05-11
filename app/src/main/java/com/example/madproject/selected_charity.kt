package com.example.madproject

    import android.os.Bundle
    import android.widget.Button
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity

class selected_charity : AppCompatActivity() {

    private lateinit var charityId: TextView
    private lateinit var charityname: TextView
    private lateinit var charityaddress: TextView
    private lateinit var charitycontact: TextView
    private lateinit var charityemail: TextView
    private lateinit var charitydescription: TextView
    private lateinit var donateBtn:Button
    private lateinit var backToCharitiCate:Button

    override fun onCreate(

        savedInstanceState: Bundle?
    ){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_charity)

//        donateBtn.setOnClickListener {
//            val fragment = CardDetails()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fl_nav, fragment)?.commit()
//        }
//
//        backToCharitiCate.setOnClickListener {
//            val fragment = Educational_charity_list()
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.fl_nav, fragment)?.commit()
//        }

        initView()

        setValuesToViews()
    }

    private fun initView() {
        charityId = findViewById(R.id.charityId)
        charityname = findViewById(R.id.charityName)
        charityaddress = findViewById(R.id.charitiaddress)
        charitycontact = findViewById(R.id.charityContact)
        charityemail = findViewById(R.id.charityEmail)
        charitydescription = findViewById(R.id.charityDescription)



//        val args = arguments
//        if (args != null) {
//            charityId.text = args.getString("Charity Id")
//            charityname.text = args.getString("Charity Name")
//            charityaddress.text = args.getString("Charity Address")
//            charitycontact.text = args.getString("Charity Contact")
//            charityemail.text = args.getString("Charity Email")
//            charitydescription.text = args.getString("Charity Description")
//        }
    }

    private fun setValuesToViews() {
        charityId.text = intent.getStringExtra("charityId")
        charityname.text = intent.getStringExtra("charityName")
        charityaddress.text = intent.getStringExtra("charityAddress")
        charitycontact.text = intent.getStringExtra("charityContact")
        charityemail.text = intent.getStringExtra("charityEmail")
        charitydescription.text = intent.getStringExtra("charityDescription")
    }

}
