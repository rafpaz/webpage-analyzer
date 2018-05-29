import React, { Component } from 'react';
import MyTable from './MyTable';

class DataTable extends Component {
	constructor(props){
		super(props);
	}

	render() {
		return (
			<div>
                <h3>General Details</h3>
                <div className="container">
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th>Property</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Html Version</td>
                                <td>{this.props.data.htmlVersion.htmlVersion}</td>
                            </tr>
                            <tr>
                                <td>Page Title</td>
                                <td>{this.props.data.htmlVersion.htmlVersion}</td>
                            </tr>
                            <tr>
                                <td>Inner Links</td>
                                <td>{this.props.data.links.linksSummary.innerLinks}</td>
                            </tr>
                            <tr>
                                <td>External Links</td>
                                <td>{this.props.data.links.linksSummary.externalLinks}</td>
                            </tr>
                            <tr>
                                <td>Is Login Page</td>
                                <td>{this.props.data.loginForm ? "Yes" : "No"}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <MyTable 
                    title="Heading Summary"
                    headers={['Type', 'Count']}
                    data={this.props.data.heading.headingValues}
                    isObject={true}
                />
                <MyTable 
                    title="Links Availability Details"
                    headers={['Link', 'Available', 'Reason']}
                    data={this.props.data.links.linksData}
                    isObject={false}
                />
            </div>
		);
	}
}

export default DataTable;