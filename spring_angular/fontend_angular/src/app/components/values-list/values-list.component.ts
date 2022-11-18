import { Component, OnInit } from '@angular/core';
import { Value } from 'src/app/models/value.model';
import { ValueService } from 'src/app/services/value.service';

@Component({
    selector: 'app-values-list',
    templateUrl: './values-list.component.html',
    styleUrls: ['./values-list.component.scss'],
})
export class ValuesListComponent implements OnInit {
    values?: Value[];
    currentValue: Value = {};
    currentIndex = -1;
    title = '';

    constructor(private valueService: ValueService) {}

    ngOnInit(): void {
        this.retrieveValues();
    }

    retrieveValues(): void {
        this.valueService.getAll().subscribe({
            next: (data) => {
                this.values = data;
                console.log(data);
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
        this.currentValue = value;
        this.currentIndex = index;
    }

    removeAllValues(): void {
        this.valueService.deleteAll().subscribe({
            next: (res) => {
                console.log(res);
                this.refreshList();
            },
            error: (e) => console.error(e),
        });
    }

    searchTitle(): void {
        this.currentValue = {};
        this.currentIndex = -1;

        this.valueService.findByTitle(this.title).subscribe({
            next: (data) => {
                this.values = data;
                console.log(data);
            },
            error: (e) => console.error(e),
        });
    }
}
