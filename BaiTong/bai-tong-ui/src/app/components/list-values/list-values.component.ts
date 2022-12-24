import { Component, OnInit } from '@angular/core';
import { Value } from 'src/app/models/value.model';
import { ValueService } from 'src/app/services/value.service';

@Component({
    selector: 'app-list-values',
    templateUrl: './list-values.component.html',
    styleUrls: ['./list-values.component.scss'],
})
export class ListValuesComponent implements OnInit {
    values?: Value[];
    currentValue: Value = {};
    currentIndex = -1;
    tenhang = '';

    constructor(private valueService: ValueService) {}

    ngOnInit(): void {
        this.retrieveValues();
    }

    retrieveValues(): void {
        this.valueService.getAll().subscribe({
            next: (data) => {
                this.values = data;
            },
            error: (e) => console.error(e),
        });
    }

    refreshList(): void {
        this.retrieveValues();
        this.currentValue = {};
        this.currentIndex = -1;
    }

    setActiveValue(value: Value, index: number): void {
        this.currentValue = {
            ...value,
        };
        this.currentIndex = index;
    }

    searchTitle(): void {
        this.currentValue = {};
        this.currentIndex = -1;

        this.valueService.findByTitle(this.tenhang).subscribe({
            next: (data) => {
                this.values = data;
                console.log(data);
            },
            error: (e) => console.error(e),
        });
    }
}
