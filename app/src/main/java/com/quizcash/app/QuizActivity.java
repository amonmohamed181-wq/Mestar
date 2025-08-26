package com.quizcash.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

    private TextView questionText, timerText;
    private Button choice1, choice2, choice3, choice4;
    private int questionIndex = 0;
    private int wrongAnswers = 0;

    private String[] questions = {
            "ما هي عاصمة مصر؟",
            "ما حاصل ضرب 5 × 6؟",
            "ما هو الكوكب الأقرب للشمس؟",
            "ما هو أطول نهر في العالم؟",
            "كم عدد ألوان قوس قزح؟",
            "ما هي عاصمة فرنسا؟",
            "من مكتشف أمريكا؟",
            "ما هي أكبر قارة في العالم؟",
            "من هو مؤسس شركة مايكروسوفت؟",
            "ما هو الحيوان الذي يلقب بملك الغابة؟",
            "ما هو أكبر محيط في العالم؟",
            "في أي سنة اندلعت الحرب العالمية الثانية؟",
            "كم عدد الكواكب في المجموعة الشمسية؟",
            "ما هي عملة اليابان؟",
            "من هو صاحب لوحة الموناليزا؟",
            "ما هو أسرع حيوان بري؟",
            "ما هو العنصر الكيميائي الذي يرمز له بـ O؟",
            "كم عدد أضلاع المثلث؟",
            "أين تقع الأهرامات؟",
            "ما هو الحيوان الذي يبيض ولا يلد؟",
            "ما هي عاصمة إيطاليا؟",
            "من هو النبي الذي ابتلعه الحوت؟",
            "ما هو أصغر كوكب في المجموعة الشمسية؟",
            "ما هي أكبر دولة عربية مساحة؟",
            "كم ثانية في الدقيقة؟",
            "من هو أول خليفة للمسلمين؟",
            "ما اسم البحر الذي يفصل بين السعودية والسودان؟",
            "ما هي عاصمة المغرب؟",
            "من هو أسرع طائر في العالم؟",
            "كم قارة في العالم؟",
            "ما هو الحيوان الذي يعيش في الماء والبر؟",
            "ما هي عاصمة إنجلترا؟",
            "من هو مؤلف رواية الحرب والسلام؟",
            "ما هي لغة البرازيل الرسمية؟",
            "ما هو الغاز الذي نتنفسه؟",
            "ما هو اسم أول مسجد في الإسلام؟",
            "كم عدد أيام الأسبوع؟",
            "من هو العالم الذي اكتشف الجاذبية؟",
            "ما هي أكبر دولة في إفريقيا؟",
            "ما هو الحيوان الذي يسمى سفينة الصحراء؟",
            "ما هو الكوكب الأحمر؟",
            "ما اسم العملة الأمريكية؟",
            "ما هو أسرع المخلوقات البحرية؟",
            "ما هي عاصمة السعودية؟",
            "من هو مخترع المصباح الكهربائي؟",
            "ما اسم أطول جبل في العالم؟",
            "كم عدد قلوب الأخطبوط؟",
            "ما هي عاصمة السودان؟",
            "من هو آخر الأنبياء؟"
    };

    private String[][] choices = {
            {"القاهرة", "الإسكندرية", "أسوان", "الجيزة"},
            {"10", "30", "20", "25"},
            {"المشتري", "الزهرة", "عطارد", "المريخ"},
            {"النيل", "الأمازون", "الدانوب", "اليانغتسي"},
            {"5", "6", "7", "8"},
            {"مدريد", "باريس", "روما", "لندن"},
            {"كولومبوس", "ماجلان", "ماركو بولو", "أميركو"},
            {"أوروبا", "إفريقيا", "آسيا", "أمريكا"},
            {"ستيف جوبز", "إيلون ماسك", "بيل غيتس", "زوكربيرغ"},
            {"النمر", "الأسد", "الفيل", "الفهد"},
            {"الأطلسي", "الهادي", "الهندي", "المتجمد"},
            {"1914", "1939", "1945", "1920"},
            {"7", "8", "9", "10"},
            {"الين", "الدولار", "اليورو", "اليوان"},
            {"دافنشي", "بيكاسو", "فان غوخ", "مايكل أنجلو"},
            {"الفهد", "الحصان", "الغزال", "النمر"},
            {"أكسجين", "هيدروجين", "كربون", "نيتروجين"},
            {"2", "3", "4", "5"},
            {"الهند", "اليونان", "مصر", "إيطاليا"},
            {"الأفعى", "الحصان", "الديك", "الدب"},
            {"برلين", "مدريد", "روما", "فيينا"},
            {"موسى", "يونس", "إبراهيم", "محمد"},
            {"عطارد", "المريخ", "الأرض", "نبتون"},
            {"الجزائر", "مصر", "السعودية", "ليبيا"},
            {"30", "50", "60", "100"},
            {"أبو بكر", "عمر", "عثمان", "علي"},
            {"الأحمر", "الميت", "الكاريبي", "الأبيض"},
            {"طنجة", "مراكش", "الرباط", "فاس"},
            {"النسر", "البومة", "النعامة", "الصقر"},
            {"4", "5", "6", "7"},
            {"الثعلب", "التمساح", "الضفدع", "الكلب"},
            {"لندن", "مانشستر", "ليفربول", "برمنغهام"},
            {"تولستوي", "دوستويفسكي", "شيكسبير", "هوميروس"},
            {"الإسبانية", "الإنجليزية", "البرتغالية", "الفرنسية"},
            {"أكسجين", "هيدروجين", "كربون", "نيتروجين"},
            {"قباء", "الأقصى", "الحرام", "قبة الصخرة"},
            {"5", "6", "7", "8"},
            {"داروين", "غاليليو", "نيوتن", "أينشتاين"},
            {"مصر", "ليبيا", "السودان", "الجزائر"},
            {"الحصان", "البقرة", "الجمل", "الحمار"},
            {"الزهرة", "المريخ", "المشتري", "نبتون"},
            {"الجنيه", "الدولار", "اليورو", "الين"},
            {"القرش", "الحوت الأزرق", "التونة", "الدلفين"},
            {"الرياض", "جدة", "مكة", "الدمام"},
            {"أديسون", "نيوتن", "تسلا", "مورس"},
            {"الهيمالايا", "الأطلس", "إيفرست", "كينيا"},
            {"2", "3", "4", "5"},
            {"الخرطوم", "جوبا", "بورتسودان", "مدني"},
            {"موسى", "عيسى", "محمد", "إبراهيم"}
    };

    private int[] correctAnswers = {
            0,1,2,1,2,1,0,2,2,1,
            1,1,1,0,0,0,0,1,2,0,
            2,1,0,0,2,0,0,2,2,3,
            2,0,0,2,0,0,2,2,3,2,
            1,1,0,2,0,0,2,0,0,2
    };

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        timerText = findViewById(R.id.timerText);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);

        loadQuestion();

        choice1.setOnClickListener(v -> checkAnswer(0));
        choice2.setOnClickListener(v -> checkAnswer(1));
        choice3.setOnClickListener(v -> checkAnswer(2));
        choice4.setOnClickListener(v -> checkAnswer(3));
    }

    private void loadQuestion() {
        if (questionIndex >= questions.length) {
            Toast.makeText(this, "مبروك! خلصت الاختبار", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        questionText.setText(questions[questionIndex]);
        choice1.setText(choices[questionIndex][0]);
        choice2.setText(choices[questionIndex][1]);
        choice3.setText(choices[questionIndex][2]);
        choice4.setText(choices[questionIndex][3]);

        startTimer();
    }

    private void startTimer() {
        if (timer != null) timer.cancel();

        timer = new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerText.setText("الوقت: " + millisUntilFinished / 1000 + " ث");
            }

            public void onFinish() {
                wrongAnswers++;
                checkGameOver();
                questionIndex++;
                loadQuestion();
            }
        }.start();
    }

    private void checkAnswer(int choice) {
        timer.cancel();
        if (choice == correctAnswers[questionIndex]) {
            Toast.makeText(this, "إجابة صحيحة ✅", Toast.LENGTH_SHORT).show();
        } else {
            wrongAnswers++;
            Toast.makeText(this, "إجابة خاطئة ❌", Toast.LENGTH_SHORT).show();
            checkGameOver();
        }
        questionIndex++;
        loadQuestion();
    }

    private void checkGameOver() {
        if (wrongAnswers >= 4) {
            Toast.makeText(this, "تم حذف حسابك بسبب 4 أخطاء", Toast.LENGTH_LONG).show();
            Intent i = new Intent(QuizActivity.this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }
}
