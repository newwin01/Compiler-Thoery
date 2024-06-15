import pandas as pd
import math

def isNaN(num):
    return num != num

# Load the CSV file
file_path = 'shift.csv'  # Update the file path accordingly
lr1_table = pd.read_csv(file_path, encoding='ISO-8859-1')

# Print the original column names to inspect them
print("Original columns:", lr1_table.columns.tolist())

# Normalize column names by stripping leading/trailing whitespaces and converting to lower case
# normalized_columns = [col.strip().lower() for col in lr1_table.columns]
# lr1_table.columns = normalized_columns

# Print normalized columns for debugging
print("Normalized columns:", lr1_table.columns.tolist())

# Check if 'state' column is present after normalization
if 'state' not in lr1_table.columns:
    raise KeyError("The 'state' column is not found in the CSV file.")

# Extract headers starting from the second column
action_columns = lr1_table.columns[1:]
print(action_columns)
# Generate shift table commands
commands = []

# Iterate over the rows
for index, row in lr1_table.iterrows():
    state = row['state']
    if pd.notnull(state):  # Ensure the state is not NaN
        for terminal in action_columns:
            action = row[terminal]
            
            if isinstance(action, str):
                if action.startswith('s'):
                    next_state = action[1:]  # Extract the state number after 's'
                    commands.append(f'ParsingTable.addShiftTable({state}, "{terminal}", {next_state});')
                elif action.startswith('r'):
                    rule = action[1:]  # Extract the rule number after 'r'
                    commands.append(f'ParsingTable.addReduceTable({state}, "{terminal}", {rule});')
                elif action == 'acc':
                    commands.append(f'ParsingTable.addAcceptTable({state}, "{terminal}");')
                    # print("hello")
                    
            # if terminal.isupper() and not isNaN(action):                 
            #     intaction = int(action)
            #     commands.append(f'ParsingTable.addGotoTable({state}, "{terminal}", {intaction});')
                
# Print commands
for command in commands:
    print(command)

