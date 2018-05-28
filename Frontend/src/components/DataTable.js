import React, { Component } from 'react';
import MyTable from './MyTable';

class DataTable extends Component {
	constructor(props){
		super(props);
	}

	render() {
		return (
			<div>
                <MyTable 
                    title="Heading Summary"
                    headers={['Type', 'Count']}
                    data={this.props.data.heading.headingValues}
                />
                <MyTable 
                    title="Links Availability Details"
                    headers={['Link', 'Available', 'Reason']}
                    data={this.props.data.links.linksData}
                />
            </div>
		);
	}
}

export default DataTable;