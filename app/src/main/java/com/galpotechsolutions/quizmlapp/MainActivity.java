package com.galpotechsolutions.quizmlapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //Use to get the final grade
    int finalGrade = 0;
    //Use to check if answer was correct or not
    int answerQuestionOne = 0;
    int answerQuestionTwo = 0;
    int answerQuestionThree = 0;
    int answerQuestionFour = 0;

    @BindView(R.id.answer_view)
    EditText textAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if(savedInstanceState != null){

        }
    }
    /**
     * This method is called when the submit button is clicked on Question 1.
     */
    public void submitQuestionOne(View view){
        EditText answerText = findViewById(R.id.answer_view);
        String answerEditText = answerText.getText().toString();

        CharSequence text = "Your answer was: " + answerEditText;
        int duration = Toast.LENGTH_LONG;

        if (answerEditText.matches("")){
            CharSequence emptyEditText = "You did not enter an answer";
            Toast toast = Toast.makeText(this,emptyEditText, duration);
            toast.show();
        }else if (answerEditText.equals("Machine Learning")){
            finalGrade += 1;

            answerQuestionOne = 1;
            TextView gradedTextView = findViewById(R.id.graded_text_question_one);
            gradedTextView.setText("1/1 Point (graded)");
            text = text + " . Correct.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question1);
            submitQuestionButton.setEnabled(false);
            answerText.setEnabled(false);
        }else {
            TextView gradedTextView = findViewById(R.id.graded_text_question_one);
            gradedTextView.setText("0/1 Point (graded)");
            text = text + " . Incorrect.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question1);
            submitQuestionButton.setEnabled(false);
            answerText.setEnabled(false);
        }
    }

    /**
     * This method is called when the submit button is clicked on Question 2.
     */
    public void submitQuestionTwo(View view){

        CheckBox supervisedLabel = findViewById(R.id.supervised_model_labeled);
        Boolean hasSupervisedLabel = supervisedLabel.isChecked();

        CheckBox unsupervisedUnlabel = findViewById(R.id.unsupervised_model_unlabeled);
        Boolean hasUnSupervisedUnlabel = unsupervisedUnlabel.isChecked();

        CheckBox supervisedUnlabel = findViewById(R.id.supervised_model_unlabeled);
        Boolean hasSupervisedUnlabel = supervisedUnlabel.isChecked();

        CheckBox unsupervisedLabel = findViewById(R.id.unsupervised_model_labeled);
        Boolean hasUnSupervisedLabel = unsupervisedLabel.isChecked();

        CharSequence text = "Your answer was ";
        int duration = Toast.LENGTH_LONG;

        if (!hasSupervisedLabel && !hasUnSupervisedUnlabel && !hasSupervisedUnlabel && !hasUnSupervisedLabel){
            CharSequence emptyEditText = "You did not select an answer";
            Toast toast = Toast.makeText(this,emptyEditText, duration);
            toast.show();
        }else if ((hasSupervisedLabel && hasUnSupervisedUnlabel) && (!hasSupervisedUnlabel && !hasUnSupervisedLabel) ){
            finalGrade += 1;
            answerQuestionTwo = 1;

            TextView gradedTextView = findViewById(R.id.graded_text_question_two);
            gradedTextView.setText("1/1 Point (graded)");
            text = text + "Correct.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question2);
            submitQuestionButton.setEnabled(false);
            supervisedLabel.setEnabled(false);
            unsupervisedUnlabel.setEnabled(false);
            supervisedUnlabel.setEnabled(false);
            unsupervisedLabel.setEnabled(false);
        }else{
            TextView gradedTextView = findViewById(R.id.graded_text_question_two);
            gradedTextView.setText("0/1 Point (graded)");
            text = text + "Incorrect.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question2);
            submitQuestionButton.setEnabled(false);
            supervisedLabel.setEnabled(false);
            unsupervisedUnlabel.setEnabled(false);
            supervisedUnlabel.setEnabled(false);
            unsupervisedLabel.setEnabled(false);
        }
    }

    /**
     * This method is called when the submit button is clicked on Question 3.
     */
    public void submitQuestionThree(View view){

        RadioGroup radioGroup = findViewById(R.id.rdgGroup);
        int radioButton = radioGroup.getCheckedRadioButtonId();

        RadioButton classificationRadioButton = findViewById(R.id.classification_radio_button);
        Boolean checkedClassification = classificationRadioButton.isChecked();
        RadioButton regressionRadioButton = findViewById(R.id.regression_radio_button);
        Boolean checkedRegression = regressionRadioButton.isChecked();
        RadioButton clusteringRadioButton = findViewById(R.id.clustering_radio_button);
        Boolean checkedClustering = clusteringRadioButton.isChecked();

        CharSequence text = "Your answer was ";
        int duration = Toast.LENGTH_LONG;

        if (!checkedClassification && !checkedRegression && !checkedClustering){
            CharSequence emptyEditText = "You did not select an answer";
            Toast toast = Toast.makeText(this,emptyEditText, duration);
            toast.show();
        }else if (radioButton == classificationRadioButton.getId()){
            finalGrade += 1;
            answerQuestionThree = 1;

            TextView gradedTextView = findViewById(R.id.graded_text_question_three);
            gradedTextView.setText("1/1 Point (graded)");
            text = text + "Correct.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question3);
            submitQuestionButton.setEnabled(false);
            classificationRadioButton.setEnabled(false);
            regressionRadioButton.setEnabled(false);
            clusteringRadioButton.setEnabled(false);
        }else {
            TextView gradedTextView = findViewById(R.id.graded_text_question_three);
            gradedTextView.setText("0/1 Point (graded)");
            text = text + "Incorrect.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question3);
            submitQuestionButton.setEnabled(false);
            classificationRadioButton.setEnabled(false);
            regressionRadioButton.setEnabled(false);
            clusteringRadioButton.setEnabled(false);
        }
    }

    /**
     * This method is called when the submit button is clicked on Question 3.
     */
    public void submitQuestionFour(View view){

        RadioGroup radioGroup = findViewById(R.id.rdgGroup2);
        int radioButton = radioGroup.getCheckedRadioButtonId();

        RadioButton LogisticRadioButton = findViewById(R.id.logistic_radio_button);
        Boolean checkedLogistic = LogisticRadioButton.isChecked();
        RadioButton kmeansRadioButton = findViewById(R.id.kmeans_radio_button);
        Boolean checkedKmeans = kmeansRadioButton.isChecked();
        RadioButton linearRadioButton = findViewById(R.id.linear_radio_button);
        Boolean checkedLinear = linearRadioButton.isChecked();

        CharSequence text = "Your answer was ";
        int duration = Toast.LENGTH_LONG;

        if (!checkedLogistic && !checkedKmeans && !checkedLinear){
            CharSequence emptyEditText = "You did not select an answer";
            Toast toast = Toast.makeText(this,emptyEditText, duration);
            toast.show();
        }else if (radioButton == LogisticRadioButton.getId()){
            finalGrade += 1;
            answerQuestionFour = 1;

            TextView gradedTextView = findViewById(R.id.graded_text_question_four);
            gradedTextView.setText("1/1 Point (graded)");
            text = text + "Correct.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question3);
            submitQuestionButton.setEnabled(false);
            LogisticRadioButton.setEnabled(false);
            kmeansRadioButton.setEnabled(false);
            linearRadioButton.setEnabled(false);
        }else {
            TextView gradedTextView = findViewById(R.id.graded_text_question_four);
            gradedTextView.setText("0/1 Point (graded)");
            text = text + "Incorrect.";
            Toast toast = Toast.makeText(this,text, duration);
            toast.show();

            Button submitQuestionButton = findViewById(R.id.submit_question4);
            submitQuestionButton.setEnabled(false);
            LogisticRadioButton.setEnabled(false);
            kmeansRadioButton.setEnabled(false);
            linearRadioButton.setEnabled(false);
        }
    }

    /**
     * This method is called when the send button is clicked.
     */
    public void sendResults(View view){
        EditText nameText = findViewById(R.id.name_view);
        String nameEditText = nameText.getText().toString();

        String resultMessage = createResultSummary(nameEditText);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "The result for " + nameEditText); //TODO:
        intent.putExtra(Intent.EXTRA_TEXT, resultMessage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    /**
     * Create summary of the test
     * @param nameText is the name of the person taking the exam
     * @return the final message
     */
    public String createResultSummary(String nameText){

        String resultMessage = "Name: " + nameText;
        resultMessage += "\nYou answer to " + finalGrade + " out of 4 questions!";
        if (answerQuestionOne == 1){
            resultMessage += "\n1. Correct. Your answer was Machine Learning.";
        }else {
            resultMessage += "\n1. Incorrect. The correct answer is Machine Learning.";
        }

        if (answerQuestionTwo == 1){
            resultMessage += "\n2. Correct. You answer was Supervised models are trained on labeled data and Unsupervised models are trained on unlabeled data.";
        }else {
            resultMessage += "\n2. Incorrect. The correct answer is Supervised models are trained on labeled data and Unsupervised models are trained on unlabeled data.";
        }

        if (answerQuestionThree == 1){
            resultMessage += "\n3. Correct. You answer was Classification Model.";
        }else {
            resultMessage += "\n3. Incorrect. The correct answer is Classification Model.";
        }

        if (answerQuestionFour == 1){
            resultMessage += "\n4. Correct. You answer was Logistic Regression .";
        }else {
            resultMessage += "\n4. Incorrect. The correct answer is Logistic Regression.";
        }

        return resultMessage;
    }
    /**
     * This method is called when the Try Again button is clicked.
     */
    public void resetTest(View view){

        /**
         * Reset the global variables
         */
        finalGrade = 0;
        answerQuestionOne = 0;
        answerQuestionTwo = 0;
        answerQuestionThree = 0;
        answerQuestionFour = 0;

        /**
         * Enable the question 1. This is a EditText
         */
        EditText answerText = findViewById(R.id.answer_view);
        answerText.getText().clear();
        answerText.setEnabled(true);

        /**
         * Enable the question2. These are checkBoxes
         */
        CheckBox supervisedLabel = findViewById(R.id.supervised_model_labeled);
        supervisedLabel.setChecked(false);

        CheckBox unsupervisedUnlabel = findViewById(R.id.unsupervised_model_unlabeled);
        unsupervisedUnlabel.setChecked(false);

        CheckBox supervisedUnlabel = findViewById(R.id.supervised_model_unlabeled);
        supervisedUnlabel.setChecked(false);

        CheckBox unsupervisedLabel = findViewById(R.id.unsupervised_model_labeled);
        unsupervisedLabel.setChecked(false);

        supervisedLabel.setEnabled(true);
        unsupervisedUnlabel.setEnabled(true);
        supervisedUnlabel.setEnabled(true);
        unsupervisedLabel.setEnabled(true);

        /**
         * Enable the question3. These are radioButtons
         */
        RadioButton classificationRadioButton = findViewById(R.id.classification_radio_button);
        classificationRadioButton.setChecked(false);
        RadioButton regressionRadioButton = findViewById(R.id.regression_radio_button);
        regressionRadioButton.setChecked(false);
        RadioButton clusteringRadioButton = findViewById(R.id.clustering_radio_button);
        clusteringRadioButton.setChecked(false);

        classificationRadioButton.setEnabled(true);
        regressionRadioButton.setEnabled(true);
        clusteringRadioButton.setEnabled(true);

        /**
         * Enable the question 4. These are radioButtons
         */
        RadioButton logisticRadioButton = findViewById(R.id.logistic_radio_button);
        logisticRadioButton.setChecked(false);
        RadioButton kmeansRadioButton = findViewById(R.id.kmeans_radio_button);
        kmeansRadioButton.setChecked(false);
        RadioButton linearRadioButton = findViewById(R.id.linear_radio_button);
        linearRadioButton.setChecked(false);

        logisticRadioButton.setEnabled(true);
        kmeansRadioButton.setEnabled(true);
        linearRadioButton.setEnabled(true);

        /**
         * Enable all button in the application.
         */
        Button submitQuestionButton = findViewById(R.id.submit_question1);
        submitQuestionButton.setEnabled(true);
        Button submitQuestionTwoButton = findViewById(R.id.submit_question2);
        submitQuestionTwoButton.setEnabled(true);
        Button submitQuestionThreeButton = findViewById(R.id.submit_question3);
        submitQuestionThreeButton.setEnabled(true);
        Button submitQuestionFourButton = findViewById(R.id.submit_question4);
        submitQuestionFourButton.setEnabled(true);
    }
}
