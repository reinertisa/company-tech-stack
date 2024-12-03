import {map} from 'lodash';

export default function CompanyList({data = []}) {
    return (
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Size</th>
                    <th>Industry</th>
                    <th>Country</th>
                </tr>
            </thead>
            <tbody>
            {map(data, (val) => {
                return (
                    <tr key={val.id}>
                        <td>{val?.name}</td>
                        <td>{val?.type}</td>
                        <td>{val?.size}</td>
                        <td>{val?.industry}</td>
                        <td>{val?.country}</td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
}