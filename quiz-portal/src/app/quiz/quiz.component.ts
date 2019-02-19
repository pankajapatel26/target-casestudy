import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuizService } from '../shared/services/quiz.service';
import { RouterConfigLoader } from '@angular/router/src/router_config_loader';
import { MatRadioChange, MatCheckboxChange } from '@angular/material';

class User {
    id: any;
    userSelections: UserSelections[];
}

class UserSelections {
    queId: any;
    answer: any;
} 

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  quiz: any;
  quizId: number;
  questions: any[];
  sub : any;

  userSelections: Map<number, string> = new Map<number, string>();
  timeLeft: number;
  interval;

  startTimer() {
    this.interval = setInterval(() => {
      if(this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.submitQuiz();
      }
    },1000)
  }


  constructor(private activatedRoute: ActivatedRoute, private router: Router, private service: QuizService) { }

  ngOnInit() {
    this.sub = this.activatedRoute.params.subscribe(params => {
      this.quizId = +params['id']; // (+) converts string 'id' to a number
    });
    this.getQuiz();
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  onChange(queId:number, value: string, event:MatCheckboxChange) {
    let savedValue = this.userSelections.get(queId);
    if(savedValue) {
      if (event.checked) {
        savedValue = savedValue + value;
      } else {
        savedValue = savedValue.replace(value, ''); 
      }
      this.userSelections.set(queId,savedValue);
      console.log(this.userSelections);
    } else {
      this.userSelections.set(queId, value);
      console.log(this.userSelections);
    }
    
  }

  submitQuiz() {
    clearInterval(this.interval);
    let userId = +localStorage.getItem("id");
    let us : UserSelections[] = [];
    let user: User = new User();
    user.id = userId;
    
    for (let key of Array.from( this.userSelections.keys())) {
       let s : UserSelections = new UserSelections();
       s.queId = key;
       s.answer = this.userSelections.get(key);
       us.push(s);
    }
    user.userSelections = us;

    this.service.assessQuiz(user, this.quizId).subscribe(data => {
      console.log(data);
      alert("Your test percentage is : " + data.percentage);
      this.router.navigate(["/result/"+ userId]);
    },
    error => {
      console.log(error);
    });
  }


  radioChange(queId:number, event: MatRadioChange) {
    this.userSelections.set(queId, event.value);
    console.log(this.userSelections);
  }

  getQuiz() {
    this.service.getQuiz(this.quizId).subscribe( data => {
        this.quiz = data;
        this.timeLeft = this.quiz.duration;
        this.questions = this.quiz.questions;
        this.startTimer();
    },
    error => {
      console.log(error)
    });
  }

}
