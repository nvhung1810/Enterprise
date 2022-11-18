import { Component, OnInit } from '@angular/core';
import { Value } from 'src/app/models/value.model';
import { ValueService } from 'src/app/services/value.service';

@Component({
    selector: 'app-add-value',
    templateUrl: './add-value.component.html',
    styleUrls: ['./add-value.component.scss'],
})
export class AddValueComponent implements OnInit {
    value: Value = {
        title: '',
        description: '',
        published: false,
    };
    submitted = false;

    constructor(private valueService: ValueService) {}

    saveTutorial(): void {
        const data = {
            title: this.value.title,
            description: this.value.description,
        };

        this.valueService.create(data).subscribe({
            next: (res) => {
                console.log(res);
                this.submitted = true;
            },
            error: (e) => console.error(e),
        });
    }

    newTutorial(): void {
        this.submitted = false;
        this.value = {
            title: '',
            description: '',
            published: false,
        };
    }

    ngOnInit(): void {}
}
