import React, { Component } from 'react';
import './App.css';
import 'whatwg-fetch';
import DataTable from './components/DataTable';
import mockData from './components/mockData';

const _API = "http://localhost:8080/api/analyze?url="

class App extends Component {
	constructor(props){
		super(props);
		this.state = {
			url: "",
			contentFetched: false,
			data: {},
			showTables: false
		};
		this.handleInputChange = this.handleInputChange.bind(this);
		this.onSubmit = this.onSubmit.bind(this);
	}

	handleInputChange(event){
		const target = event.target;
		const value = target.value;
		const name = target.name;

		this.setState({
			[name]: value
		});
	}
	
	onSubmit(){
		let encodeUrl = encodeURIComponent(this.state.url);
		let fullUrl = _API + encodeUrl;
		this.setState({
			data: mockData,
			showTables: true
		});
		console.log(mockData);
		// fetch(fullUrl).then(res => res.json())
		// 	.then(json => {
		// 		this.setState({
		// 			data: json,
		// 			showTables: true
		// 		});
		// 	});
	}

	render() {
		return (
			<div className="App">
				<h1>Analyze Webpage</h1>
				<div className="container">
					<div className="row justify-content-around">
						<input className="form-control form-input col-8"
									id="url-input"
									name="url" required
									onChange={this.handleInputChange}
									value={this.state.url}
									placeholder="Enter url"
							/>
						<button className="btn btn-secondary col-2" onClick={this.onSubmit}>Send</button>
					</div>
				</div>
				{this.state.showTables && <DataTable data={this.state.data}/> }
			</div>
		);
	}
}

export default App;
