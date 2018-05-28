import React, { Component } from 'react';

class MyTable extends Component {
	constructor(props){
		super(props);
	}

	render() {
		return (
			<div>
        <h3>{this.props.title}</h3>
        <div className="container">
            <table className="table table-striped">
                <thead>
                    <tr>
                        {this.props.headers.map((header, i) => (
                            <th scope="col" key={i}>{header}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {Object.entries(this.props.data).map((item, i) => (
				            <tr key={i}>
                                {item.map(cell => (
                                    <td>{cell}</td>
                                ))}
                            </tr>
			            ))}                        
                </tbody>
            </table>
        </div>
    </div>
		);
	}
}

export default MyTable;