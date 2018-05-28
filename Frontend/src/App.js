import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import 'whatwg-fetch';

const _API = "http://localhost:8080/api/analyze?url="

class App extends Component {
	constructor(props){
		super(props);
		this.state = {
			url: "",
			contentFetched: false,
			data: {}
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
		fetch(fullUrl).then(res => res.json())
			.then(json => {
				debugger;
			});
	}

	render() {
		return (
			<div className="App">
				<h1>Analyze Webpage</h1>
				<div className="container">
					<div className="row">
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
			</div>
		);
	}
}

export default App;
