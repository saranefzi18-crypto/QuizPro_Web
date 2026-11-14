import { Component } from '@angular/core';
import { Quiz } from '../models/quiz';

import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-formpage',
  imports: [CommonModule],
  templateUrl: './formpage.component.html',
  styleUrl: './formpage.component.css'
})
export class FormpageComponent {
  listQuiz : Quiz[] =[]
}
